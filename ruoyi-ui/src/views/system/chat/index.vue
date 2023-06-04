<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户名" prop="username">
        <el-input
          v-model="queryParams.username"
          placeholder="请输入用户名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户api-key" prop="userKey">
        <el-input
          v-model="queryParams.userKey"
          placeholder="请输入用户api-key"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="使用的model类型" prop="model">
        <el-input
          v-model="queryParams.model"
          placeholder="请输入使用的model类型"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否结束" prop="isEnd">
        <el-input
          v-model="queryParams.isEnd"
          placeholder="请输入是否结束"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户ip地址" prop="requestIpAddress">
        <el-input
          v-model="queryParams.requestIpAddress"
          placeholder="请输入用户ip地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="问题ID" prop="promptId">
        <el-input
          v-model="queryParams.promptId"
          placeholder="请输入问题ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="问答结束的原因" prop="finishReason">
        <el-input
          v-model="queryParams.finishReason"
          placeholder="请输入问答结束的原因"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="请求完成的时间" prop="requestTime">
        <el-input
          v-model="queryParams.requestTime"
          placeholder="请输入请求完成的时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="要生成的最大字符数" prop="maxTokens">
        <el-input
          v-model="queryParams.maxTokens"
          placeholder="请输入要生成的最大字符数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="采样温度" prop="temperature">
        <el-input
          v-model="queryParams.temperature"
          placeholder="请输入采样温度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="运行的线程名称" prop="threadName">
        <el-input
          v-model="queryParams.threadName"
          placeholder="请输入运行的线程名称"
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
          v-hasPermi="['system:chat:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:chat:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:chat:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:chat:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="chatList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="对话id" align="center" prop="chatId" />
      <el-table-column label="用户名" align="center" prop="username" />
      <el-table-column label="用户api-key" align="center" prop="userKey" />
      <el-table-column label="使用的model类型" align="center" prop="model" />
      <el-table-column label="问题" align="center" prop="prompt" />
      <el-table-column label="答案" align="center" prop="answer" />
      <el-table-column label="是否结束" align="center" prop="isEnd" />
      <el-table-column label="用户ip地址" align="center" prop="requestIpAddress" />
      <el-table-column label="返回的responseJSON串" align="center" prop="responseJson" />
      <el-table-column label="问题ID" align="center" prop="promptId" />
      <el-table-column label="问答结束的原因" align="center" prop="finishReason" />
      <el-table-column label="请求的url" align="center" prop="requestUrl" />
      <el-table-column label="请求完成的时间" align="center" prop="requestTime" />
      <el-table-column label="要生成的最大字符数" align="center" prop="maxTokens" />
      <el-table-column label="采样温度" align="center" prop="temperature" />
      <el-table-column label="运行的线程名称" align="center" prop="threadName" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:chat:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:chat:remove']"
          >删除</el-button>
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

    <!-- 添加或修改ChatGPT管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item label="用户api-key" prop="userKey">
          <el-input v-model="form.userKey" placeholder="请输入用户api-key" />
        </el-form-item>
        <el-form-item label="使用的model类型" prop="model">
          <el-input v-model="form.model" placeholder="请输入使用的model类型" />
        </el-form-item>
        <el-form-item label="问题" prop="prompt">
          <el-input v-model="form.prompt" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="答案" prop="answer">
          <el-input v-model="form.answer" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="是否结束" prop="isEnd">
          <el-input v-model="form.isEnd" placeholder="请输入是否结束" />
        </el-form-item>
        <el-form-item label="用户ip地址" prop="requestIpAddress">
          <el-input v-model="form.requestIpAddress" placeholder="请输入用户ip地址" />
        </el-form-item>
        <el-form-item label="返回的responseJSON串" prop="responseJson">
          <el-input v-model="form.responseJson" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="问题ID" prop="promptId">
          <el-input v-model="form.promptId" placeholder="请输入问题ID" />
        </el-form-item>
        <el-form-item label="问答结束的原因" prop="finishReason">
          <el-input v-model="form.finishReason" placeholder="请输入问答结束的原因" />
        </el-form-item>
        <el-form-item label="请求的url" prop="requestUrl">
          <el-input v-model="form.requestUrl" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="请求完成的时间" prop="requestTime">
          <el-input v-model="form.requestTime" placeholder="请输入请求完成的时间" />
        </el-form-item>
        <el-form-item label="要生成的最大字符数" prop="maxTokens">
          <el-input v-model="form.maxTokens" placeholder="请输入要生成的最大字符数" />
        </el-form-item>
        <el-form-item label="采样温度" prop="temperature">
          <el-input v-model="form.temperature" placeholder="请输入采样温度" />
        </el-form-item>
        <el-form-item label="运行的线程名称" prop="threadName">
          <el-input v-model="form.threadName" placeholder="请输入运行的线程名称" />
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
import { listChat, getChat, delChat, addChat, updateChat } from "@/api/system/chat";

export default {
  name: "Chat",
  data() {
    return {
      // 遮罩层
      loading: true,
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
      // ChatGPT管理表格数据
      chatList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        username: null,
        userKey: null,
        model: null,
        prompt: null,
        answer: null,
        isEnd: null,
        requestIpAddress: null,
        responseJson: null,
        promptId: null,
        finishReason: null,
        requestUrl: null,
        requestTime: null,
        maxTokens: null,
        temperature: null,
        threadName: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        username: [
          { required: true, message: "用户名不能为空", trigger: "blur" }
        ],
        userKey: [
          { required: true, message: "用户api-key不能为空", trigger: "blur" }
        ],
        model: [
          { required: true, message: "使用的model类型不能为空", trigger: "blur" }
        ],
        prompt: [
          { required: true, message: "问题不能为空", trigger: "blur" }
        ],
        answer: [
          { required: true, message: "答案不能为空", trigger: "blur" }
        ],
        isEnd: [
          { required: true, message: "是否结束不能为空", trigger: "blur" }
        ],
        requestIpAddress: [
          { required: true, message: "用户ip地址不能为空", trigger: "blur" }
        ],
        promptId: [
          { required: true, message: "问题ID不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "请求创建的时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询ChatGPT管理列表 */
    getList() {
      this.loading = true;
      listChat(this.queryParams).then(response => {
        this.chatList = response.rows;
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
        chatId: null,
        username: null,
        userKey: null,
        model: null,
        prompt: null,
        answer: null,
        isEnd: null,
        requestIpAddress: null,
        responseJson: null,
        promptId: null,
        finishReason: null,
        requestUrl: null,
        createTime: null,
        requestTime: null,
        maxTokens: null,
        temperature: null,
        threadName: null
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
      this.ids = selection.map(item => item.chatId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加ChatGPT管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const chatId = row.chatId || this.ids
      getChat(chatId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改ChatGPT管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.chatId != null) {
            updateChat(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addChat(this.form).then(response => {
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
      const chatIds = row.chatId || this.ids;
      this.$modal.confirm('是否确认删除ChatGPT管理编号为"' + chatIds + '"的数据项？').then(function() {
        return delChat(chatIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/chat/export', {
        ...this.queryParams
      }, `chat_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
