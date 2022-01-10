import {request} from "../../request/index.js";
import {login} from "../../utils/asyncWx.js";
Page({
  data: {
    token:'Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOjIzLCJpYXQiOjE1NjQ3MzAwNzksImV4cCI6MTAwMTU2NDczMDA3OH0.YPt-XeLnjV-_1ITaXGY2FhxmCe4NvXuRnRB8OMCfnPo'
  },
 async handleGetUserInfo(e){
    console.log(e);
    try{
      const {encryptedData,rawData,iv,signature}=e.detail;
      //获得小程序登录成功后的code
      const {code}=await login();
      console.log("++++++");
      console.log(code);
      const loginParams={encryptedData,rawData,iv,signature,code}
      // 发送请求 获取用户的token
      const res=await request({url:"/users/wxlogin",data:loginParams,method:"POST"})
      console.log("*****");
      console.log(res);
      // const token=this.data.token;
      // wx.setStorageSync('token',token);
      // wx.navigateBack({
      //   delta: 1,
      // })
    }catch(error){
      console.log(error);
    }
  }
  
})