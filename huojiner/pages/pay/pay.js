// pages/shopping/shopping.js
import {request} from "../../request/index.js";
Page({

  /**
   * 页面的初始数据
   */
  data: {
    address:{},
    cart:[],
    // 总价格
    totalPrice:0,
    // 总数量
    totalNum:0,
    
  },
  //点击获取收货地址
 async handleChooseAddress(e){
    wx.getSetting({
      success:(result)=>{
        const scopeAddress=result.authSetting["scope.address"];
        if(scopeAddress===true||scopeAddress==undefined){
           //获取用户地址
           wx.chooseAddress({
              success: (result2) => {
                console.log(result2);
                let address=result2;
                wx.setStorageSync('address', address);
              },
            });
        }else{
          //用户以前拒绝过授予权限
          wx.openSetting({
            success:(result3)=>{
              //获取用户地址
            wx.chooseAddress({
              success: (result4) => {
                console.log(result4);
              },
            });
            }
          })
        }
      },
    });
  },
  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    //获取本地缓存数据
    const address=wx.getStorageSync('address');
    const cart=wx.getStorageSync('cart')||[];
    // 过滤后的购物车数组
    cart.filter(v=>v.checked);
    this.setData({address});
    this.setData({cart})
    // 总数量和总价格
    let totalPrice=0;
    let totalNum=0;
    cart.forEach(v => {
        totalPrice+=v.num*v.goods_price;
        totalNum+=v.num;
    });
    //给data里的数据赋值
    this.setData({
      address,
      cart,
      totalPrice,
      totalNum,
    });
  },
 async handlePrderPay(){
    //判断缓存中是否有token
    const token=wx.getStorageSync('token');
    //判断
    if(!token){
      wx.navigateTo({
        url: '../auth/auth',
      })
      return;
    }
    console.log("已经有token了");
    //创建订单 请求头参数
    const hender={Authorization:token};
    // 准备请求体
    const order_price=this.data.totalPrice;
    // 
    const consignee_addr=this.data.address.all;
    const cart=this.data.cart;
    let goods=[];
    cart.forEach(v=>goods.push({
      goods_id:v.goods_id,
      goods_number:v.num,
      goods_price:v.goods_price
    }))
    const orderParams={order_price,consignee_addr,goods};
    //准备发送请求 创建订单 获取订单编号
    const res=await request({url:"/my/orders/create",method:"POST",data:orderParams,hender})
    console.log(res);
    wx.request({
      url: 'https://api-hmugo-web.itheima.net/api/public/v1/my/orders/create',
      data:orderParams,
      method:"POST",
      header:hender,
      success: function(res) {
        console.log(res)
      }
    })
  }
 })