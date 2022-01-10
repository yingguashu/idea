import {request} from "../../request/index.js"
Page({

  /**
   * 页面的初始数据
   */
  data: {
    tabs:[{
      id:0,value:"综合",isActive:true
    },{
      id:1,value:"销量",isActive:false
    },{
      id:2,value:"价格",isActive:false
    }],
    goodsList:[],
    end:true,
  },
  QueryParams:{
    query:"",
    cid:"",
    pagenum:1,
    pagesize:10,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  //从子组件Tabs那里传递过来
  onLoad: function (options) {
    this.QueryParams.cid=options.cid;
    this.getGoodsList();
  },
  totalPages:1,
  //获取商品列表数据
async getGoodsList(){
  const res=await request({url:"/goods/search",data:this.QueryParams});
  // console.log(res.data.message)
  const total=res.data.message.total
  // 计算总页数
  this.totalPages=Math.ceil(total/this.QueryParams.pagesize)
  console.log(this.totalPages)
  this.setData({
    goodsList:[...this.data.goodsList,...res.data.message.goods]
  })
  // 关闭下拉刷新的动作
  wx.stopPullDownRefresh({
    success: (res) => {},
  })
},

  handleTabsItemChange(e){
    //获取被点击的索引
    const {index}=e.detail;
    // 修改源数组
    let {tabs}=this.data;
    tabs.forEach((v,i)=>i===index?v.isActive=true:v.isActive=false);
    // 赋值到data中
    this.setData({
      tabs
    })
    console.log(e)
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    console.log("goods_list被隐藏了")
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    console.log("goods_list被卸载了")
  },

  /**
   * 页面相关事件处理函数--监听用户下拉刷新动作
   */
  onPullDownRefresh: function () {
    //重置数组
    this.setData({
      goodsList:[]
    })
    // 重置页码
    this.QueryParams.pagenum=1;
    // 发送请求
    this.getGoodsList();
    console.log("goods_list刷新了")
  },

  /**
   * 页面上拉,滚动条触底事件的处理函数
   */
  onReachBottom: function (e) {
    // 判断是否还有下一页数据
    if(this.QueryParams.pagenum>=this.totalPages){
      console.log("到底了")
      this.setData({
        end:false
      })
    }else{
      //代表还有下一页数据
      console.log("刷新中")
      this.QueryParams.pagenum++;
      this.getGoodsList();
    }
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
    
  }
})