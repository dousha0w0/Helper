import request from '@/utils/request'

// 查询课件管理列表
export function listKejian(query) {
  return request({
    url: '/system/kejian/list',
    method: 'get',
    params: query
  })
}

// 查询课件管理详细
export function getKejian(id) {
  return request({
    url: '/system/kejian/' + id,
    method: 'get'
  })
}

// 新增课件管理
export function addKejian(data) {
  return request({
    url: '/system/kejian',
    method: 'post',
    data: data
  })
}

// 修改课件管理
export function updateKejian(data) {
  return request({
    url: '/system/kejian',
    method: 'put',
    data: data
  })
}

// 删除课件管理
export function delKejian(id) {
  return request({
    url: '/system/kejian/' + id,
    method: 'delete'
  })
}
