import {request} from "../../request/index.js"
Page({

  /**
   * 页面的初始数据
   */
  data: {
    goodsObj:{},
    abc:[]
  },
  GoodsInfo:{},

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const {goods_id}=options;
    // console.log(goods_id)
    this.getGoodsDetail(goods_id);
  },
// 获取商品的详情数据
 async getGoodsDetail(goods_id){
   const goodsObj=await request({url:"/goods/detail",data:{goods_id}});
   console.log(goodsObj)
   this.GoodsInfo=goodsObj.data.message;
   this.setData({
     goodsObj
    // goodsObj:{
    //   goods_name:goodsObj.data.message.goods_name,
    //   goods_rice:goodsObj.data.message.goods_price,
    //   goods_introduce:goodsObj.data.message.goods_introduce,
    //   pics:goodsObj.data.message.goods_pics,
    // }
   })
 },
 //点击轮播图放大预览
 async handlePervewImage(){
  //  console.log(this.data.goodsObj.data.message)
   const abcd=this.data.goodsObj.data.message.pics;
   const ab=this.data.abc;
    abcd.forEach((i,v) => {
      //  console.log(i.pics_mid)
        this.data.abc[v]=i.pics_mid;
     });
  //  console.log(this.data.abc)
  //  先构造要预览的数组
   wx.previewImage({
     urls: this.data.abc,
     current: 'current',
     showmenu: true,
   })
 },
//  点击加入购物车
handleCartAdd(){
  console.log("添加成功")
  //先获取缓存中的购物车数组
  let cart=wx.getStorageSync('cart')||[];
  //判断商品是否在购物车中
  let index=cart.findIndex(v=>v.goods_id===this.GoodsInfo.goods_id);
  if(index===-1){
    console.log("不存在")
    //不存在
    this.GoodsInfo.num=1;
    this.GoodsInfo.checked=true;
    console.log(this.GoodsInfo);
    cart.push(this.GoodsInfo);
  }else{
    //已经存在了
    console.log(this.GoodsInfo);

    cart[index].num++;
    console.log("存在")
  }
  //把购物车添加到缓存中
  wx.setStorageSync('cart', cart);
  //添加弹窗提示
  wx.showToast({
    title: '成功',
    icon:'success',
    make:'true',
    success:()=>{

    }
  })
}
})