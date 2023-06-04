<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <!--      <el-form-item label="视频" prop="video">-->
      <!--        <el-input-->
      <!--          v-model="queryParams.video"-->
      <!--          placeholder="请上传视频"-->
      <!--          clearable-->
      <!--          @keyup.enter.native="handleQuery"-->
      <!--        />-->
      <!--      </el-form-item>-->
      <el-form-item label="名字" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入名字"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="老师" prop="teacherName">
        <el-input
          v-model="queryParams.teacherName"
          placeholder="请输入老师"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分类" prop="classification">
        <el-input
          v-model="queryParams.classification"
          placeholder="请输入分类"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:lesson:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:lesson:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:lesson:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:lesson:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="lessonList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="ID" align="center" prop="id"/>
      <el-table-column label="视频" align="center" prop="video"/>
      <el-table-column label="名字" align="center" prop="name"/>
      <el-table-column label="介绍" align="center" prop="description"/>
      <el-table-column label="老师" align="center" prop="teacherName"/>
      <el-table-column label="封面" align="center" prop="cover" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.cover" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="分类" align="center" prop="classification"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:lesson:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:lesson:remove']"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改课程信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="视频" prop="video">
          <file-upload v-model="form.video" :file-type="['mp4','avi','rmvb']" :file-size="4000" />
        </el-form-item>
        <el-form-item label="名字" prop="name">
          <el-input v-model="form.name" placeholder="请输入名字"/>
        </el-form-item>
        <el-form-item label="介绍" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容"/>
        </el-form-item>
        <el-form-item label="老师" prop="teacherName">
          <el-input v-model="form.teacherName" placeholder="请输入老师"/>
        </el-form-item>
        <el-form-item label="封面" prop="cover">
          <image-upload v-model="form.cover"/>
        </el-form-item>
        <el-form-item label="分类" prop="classification">
          <el-input v-model="form.classification" placeholder="请输入分类"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {listLesson, getLesson, delLesson, addLesson, updateLesson} from "@/api/system/lesson";
import EleUploadVideo from "vue-ele-upload-video";
import {getToken} from "@/utils/auth";

export default {
  name: "Lesson",
  components: {EleUploadVideo},
  data() {
    return {
      // 遮罩层
      loading: true,
      uploadImgUrl: process.env.VUE_APP_BASE_API + "/common/upload", // 上传的图片服务器地址
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 课程信息表格数据
      lessonList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      headers: {
        Authorization: "Bearer " + getToken(),
      },
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        video: null,
        name: null,
        description: null,
        teacherName: null,
        cover: null,
        classification: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        video: [
          {required: true, message: "视频不能为空", trigger: "blur"}
        ],
        name: [
          {required: true, message: "名字不能为空", trigger: "blur"}
        ],
        cover: [
          {required: true, message: "封面不能为空", trigger: "blur"}
        ],
        classification: [
          {required: true, message: "分类不能为空", trigger: "blur"}
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    //上传前回调
    beforeUploadVideo(file) {
      const isLt1024M = (file.size / 1024 / 1024) < 1024;
      this.form.videoSize = file.size / 1024 / 1024;
      //判断是不是MP4格式视频
      if (['video/mp4'].indexOf(file.type) !== 0) {
        this.$message.error('请上传正确的视频格式');
        return false;
      }
      //单个视频大小限制在1024M以内
      if (!isLt1024M) {
        this.$message.error('上传视频大小不能超过1024MB哦!');
        return false;
      }
      this.isShowUploadVideo = false;
    },

    //进度条
    uploadVideoProcess(event, file, fileList) {
      this.videoFlag = true;
      this.videoUploadPercent = file.percentage.toFixed(0) * 1;
    },

    //上传成功回调
    handleVideoSuccess(res, file) {
      this.isShowUploadVideo = true;
      this.videoFlag = false;
      this.videoUploadPercent = 0;
      if (res != "") {
        this.showVideoPath = res;
        this.form.courseUrl = res;
      } else {
        this.$message.error('视频上传失败，请重新上传！');
      }
    },
    /** 查询课程信息列表 */
    getList() {
      this.loading = true;
      listLesson(this.queryParams).then(response => {
        this.lessonList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        video: null,
        name: null,
        description: null,
        teacherName: null,
        cover: null,
        classification: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加课程信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getLesson(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改课程信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateLesson(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLesson(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除课程信息编号为"' + ids + '"的数据项？').then(function () {
        return delLesson(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/lesson/export', {
        ...this.queryParams
      }, `lesson_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
