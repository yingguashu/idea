export const getSetting=()=>{
  return new Promise((resolve,reject)=>{
    wx.getSetting({
  success:(result)=>{resolve(result);},
  fail: (err) =>{reject(err);}
  });
  })
}
export const showToast=({title})=>{
  return new Promise((resolve,reject)=>{wx.showToast({
  title: title,icon: "none",
  success :(res) =>{
  resolve(res);
  },
  fail:(err)=>{reject(err);}
  })})}
  

export const login=()=>{
  return new Promise((resolve,reject)=>{
    wx.login({
      timeout: 10000,
      success: (result) => {
        resolve(result);
      },
      fail: (err) => {
        reject(err)
      },
    })
  })
}