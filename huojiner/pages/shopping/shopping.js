// pages/shopping/shopping.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    address:{},
    cart:[],
    allChecked:false,
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
    //计算购物车的全选物品
    //every数组方法 会遍历 会接受一个回调函数 没一个回调函数都返回true
    // 那么every的返回值就是true  有一个为false every就会中断返回
    const allChecked=cart.length?cart.every(v=>v.checked):false;
    // 总数量和总价格
    let totalPrice=0;
    let totalNum=0;
    cart.forEach(v => {
      if(v.checked){
        totalPrice+=v.num*v.goods_price;
        totalNum+=v.num;
      }
    });
    //给data里的数据赋值
    this.setData({
      address,
      cart,
      allChecked,
      totalPrice,
      totalNum,
    });
    wx.showShareMenu({
      menus: ['shareAppMessage', 'shareTimeline'],
    })
  },
  //商品的选中
  handeItemChange(e){
    const goods_id=e.currentTarget.dataset.id;
    //获取购物车数组
    let {cart}=this.data;
    //找到被修改的商品对象
    let index=cart.findIndex(v=>v.goods_id===goods_id);
    //选中状态取反
    cart[index].checked=!cart[index].checked
    //把购物车数据重新设置回data和缓存中
    this.setData({
      cart
    })
    wx.setStorageSync('cart', cart)
    console.log(goods_id);
    this.onShow();
  },
  //购物车的全选和取消全选
  a(e){
    // console.log(e.detail.value);
    let cd=e.detail.value;
    if(cd.length===0){
      console.log("取消全选");
      this.qx(false)
    }else{
      console.log("全选");
      this.qx(true)
    }
  },
  qx(c){
    let cart=wx.getStorageSync('cart')
    cart.forEach(v => {
      v.checked=c;
    });
    wx.setStorageSync('cart', cart);
    this.setData({
      cart
    })
  },
  // 添加删除商品
  handleItemNumEdit(e){
      //获取添加购物车传来的参数
      const {operation,id}=e.currentTarget.dataset;
          // 获取购物车数组
      let {cart}=this.data;
      // 找到需要修改商品的索引
      const index=cart.findIndex(v=>v.goods_id===id)
      console.log(index);
      if(cart[index].num>1){
      cart[index].num+=operation
      this.setData({cart})
      wx.setStorageSync('cart', cart)
    }else if(operation>0){
      cart[index].num+=operation
      this.setData({cart})
      wx.setStorageSync('cart', cart) 
    }else{
      wx.showToast({
        title: '最少购买一件哦！',
        icon:'none',
        duration:2000,
        mask:false,
      })
    }
  },
  //删除商品
  delete(e){
    let gid=e.currentTarget.dataset.gid;
    let {cart}=this.data;
      // 找到需要修改商品的索引
    const index=cart.findIndex(v=>v.goods_id===gid)
    wx.showModal({
      title:'删除商品',
      content:'你确定要删除吗',
      success:(res)=>{
        if(res.confirm){
          console.log("用户点击了确定");
          cart.splice(index,1)
          this.setData({cart})
          wx.setStorageSync('cart', cart)
        }else{
          console.log("用户点击了取消");
        }
      }
    })
  },
  // 结算商品
  handlePay(){
    // 判断收货地址是否存在
    const {address}=this.data;
    const {cart}=this.data;
    if(!address.userName){
      wx.showToast({
        title: '你还没有填写收货地址哦^_^',
        icon:'none',
        duration:2000
      })
    }else if(cart.length===0){
      wx.showToast({
        title: '你还没有购买商品哦^_^',
        icon:'none',
        duration:2000
      })
    }else{
      console.log("转发");
      wx.navigateTo({
        url: '../pay/pay',
        success:(result)=>{

        }
      })
    }
  },
})