import request from '@/utils/request'

// 查询课程信息列表
export function listLesson(query) {
  return request({
    url: '/system/lesson/list',
    method: 'get',
    params: query
  })
}

// 查询课程信息详细
export function getLesson(id) {
  return request({
    url: '/system/lesson/' + id,
    method: 'get'
  })
}

// 新增课程信息
export function addLesson(data) {
  return request({
    url: '/system/lesson',
    method: 'post',
    data: data
  })
}

// 修改课程信息
export function updateLesson(data) {
  return request({
    url: '/system/lesson',
    method: 'put',
    data: data
  })
}

// 删除课程信息
export function delLesson(id) {
  return request({
    url: '/system/lesson/' + id,
    method: 'delete'
  })
}
