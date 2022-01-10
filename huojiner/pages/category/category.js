// pages/category/category.js
import { request } from "../../request/index.js"
Page({

  /**
   * 页面的初始数据
   */
  data: {
// 左侧菜单的数据
    leftList:[{
      title:"关于我们",
    }],
    // 右侧菜单的数据
    rightList:[],
    currentIndex:0,
    scrollTop:""
    },
     // 接口的返回数据
    Cates:[],

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // 先判断本地是否有数据
    // {time:Date.now(),data:[...]}
    // 没有旧数据，直接发送新的请求
    // 有旧数据 同时 旧的数据也没有过期 就使用本地数据即可
    // 获取本地存储数据
    const Cates=wx.getStorageSync("cates");
    // 判断是否Cates存在
    if(!Cates){
      this.getCates();
    }else{
      if(Date.now() - Cates.time>1000*10){
        this.getCates();
      }
    }
    this.getCates();
  },
  getCates(){
    request({
      url: '/categories',
    })
    .then(res=>{
      // console.log(res)
      this.Cates=res.data.message;
      // 构造左侧的大菜单数据
      let leftList=this.Cates.map(v=>v.cat_name);
      // 把接口的数据存入到接口的数据中 
      wx.setStorageSync('cates', {time:Date.now(),data:this.Cates});
      // 构造右侧的商品数据
      let rightList=this.Cates[0].children;
      this.setData({
        leftList,
        rightList
      })
    })
  },
  // 左侧菜单的单击事件
  handleItemTap(e){
   const {index}=e.currentTarget.dataset;
   let rightList=this.Cates[index].children;
   this.setData({
     currentIndex:index,
     rightList,
     //  重新设置右侧内容的scrollTop值
     scrollTop:0
   })
  

  }

})