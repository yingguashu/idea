const url=require('../pages/order/order')
export const request=(params)=>{
  wx.showLoading({
    title: '加载中',
    mask:true
  })
  
  setTimeout(function () {
    wx.hideLoading()
  }, 1000)
  //定义公共的urlhttps://api-hmugo-web.itheima.net/api/public/v1
  const basUrl="https://api-hmugo-web.itheima.net/api/public/v1"
  return new Promise((resolve,reject)=>{
    wx.request({
      ...params,
      url:basUrl+params.url,
      success:(result)=>{
        resolve(result);
      },
      fail:(err)=>{
        reject(err);
      },
      complete:()=>{
        // 关闭正在刷新的图标
        wx.hideLoading({
          success: (res) => {},
        })
      }
    });
  })
}

export const urlse=(params)=>{
  console.log(url.identityBase);
  return new Promise((resolve,reject)=>{
    wx.request({
      ...params,
      url: url.identityBase+'/.well-known/openid-configuration',
      method:"GET",
      header:{'contrnt-type':'application/json'},
      success:(res)=>{
        resolve(res)
      },
      complete:(res)=>{
      }
    })
  })
}
