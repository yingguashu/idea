import {request} from "../../request/index.js"
Page({
  /**
   * 页面的初始数据
   */
  data: {
    // 轮播图数组
    swiperList:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // 开始发送异步请求  获取轮播图
    wx.request({
      url: 'url',
      success:(result)=>{
        console.log(result)
      },
    });
  },
  gosanyuan: function(){
    wx.navigateTo({
    url: '../sanyuan/sanyuan',
    success: function() {
      
    }, //成功后的回调；
    })
  }
})