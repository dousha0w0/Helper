import request from '@/utils/request'

// 查询关键句管理列表
export function listKeysentences(query) {
  return request({
    url: '/system/keysentences/list',
    method: 'get',
    params: query
  })
}

// 查询关键句管理详细
export function getKeysentences(id) {
  return request({
    url: '/system/keysentences/' + id,
    method: 'get'
  })
}

// 新增关键句管理
export function addKeysentences(data) {
  return request({
    url: '/system/keysentences',
    method: 'post',
    data: data
  })
}

// 修改关键句管理
export function updateKeysentences(data) {
  return request({
    url: '/system/keysentences',
    method: 'put',
    data: data
  })
}

// 删除关键句管理
export function delKeysentences(id) {
  return request({
    url: '/system/keysentences/' + id,
    method: 'delete'
  })
}
