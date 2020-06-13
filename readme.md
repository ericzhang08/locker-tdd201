tasking

given locker未满 when 存包 then 存包成功，拿到ticket

given locker已满 when 存包 then 存包失败，提示储物柜已满

given 一张有效票据 when 取包，then 取包成功

given 一张无效票据 when 取包，then 取包失败，提示非法票据

given 一张重复使用票据 when 取包 then 取包失败，提示非法票据


question
测试中如何设置存包满或者未满状态。