import request from '@/utils/request'

// 查询ChatGPT管理列表
export function listChat(query) {
  return request({
    url: '/system/chat/list',
    method: 'get',
    params: query
  })
}

// 查询ChatGPT管理详细
export function getChat(chatId) {
  return request({
    url: '/system/chat/' + chatId,
    method: 'get'
  })
}

// 新增ChatGPT管理
export function addChat(data) {
  return request({
    url: '/system/chat',
    method: 'post',
    data: data
  })
}

// 修改ChatGPT管理
export function updateChat(data) {
  return request({
    url: '/system/chat',
    method: 'put',
    data: data
  })
}

// 删除ChatGPT管理
export function delChat(chatId) {
  return request({
    url: '/system/chat/' + chatId,
    method: 'delete'
  })
}
