import {urlse} from "../../request/index.js"
Page({

  /**
   * 页面的初始数据urlse
   */
  data: {
    userInfo:{},
    abcd:false
  },
  onGetuserInfo(e){
    wx.getUserProfile({
      desc: '展示用户信息', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (res) => {
        this.setData({
          userInfo: res.userInfo,
          isAuth:true
        })
      }
    })
    console.log(e);
  },
  getUPil(){
    wx.getUserProfile({
      desc: '获取你的信息',
      success:(res)=>{
        console.log(res);
        this.setData({
          userInfo:res.userInfo
        })
      }
    })
  },
  onLoad:function(){
    
  },
  a(e){
    console.log(e.detail.value);
  },
  quanju(){
    let abcd=this.data.abcd
    this.setData({
      abcd:false
    })
    console.log(abcd);
  },
  abc(){
    console.log("用户长按了");
    this.setData({
      abcd:true
    })
    
  },
 async hendleUser(){
    console.log("开始加载");
    const userr= await urlse();
    console.log(userr);
  },

})