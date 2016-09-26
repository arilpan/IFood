package com.ydxiaoyuan.ifood.api.message;

import java.util.List;

/**
 * Created by aril_pan@qq.com on 16-9-1.
 */
public class APPSelectRight {
  /**
   * success : true
   * message :
   * messageList : null
   * messageList1 : null
   * messageList2 : null
   * messageList3 : null
   * messageList4 : null
   * messageList5 : null
   * messageList6 : null
   * messageList7 : null
   * messageList8 : null
   * code : 0
   * value : [{"tagID":"1","type":null,"dishes_name":"米饭每位一元","dishes_price":"1.00",
   * "dishes_id":"e7d02f7f-5085-436a-95ce-83446cf53577",
   * "upload_url":"/GrogshopUpload/dishes/20160811085410241mf.jpg","list":null},{"tagID":"10",
   * "type":null,"dishes_name":"米饭每位一元","dishes_price":"1.00",
   * "dishes_id":"e7d02f7f-5085-436a-95ce-83446cf53577",
   * "upload_url":"/GrogshopUpload/dishes/20160811085410241mf.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"毛豆角","dishes_price":"7.20",
   * "dishes_id":"b9591534-59d2-46f9-9fe3-589d87ebfe23",
   * "upload_url":"/GrogshopUpload/dishes/20160811085148144mdj.jpg","list":null},{"tagID":"9",
   * "type":null,"dishes_name":"毛豆角","dishes_price":"7.20",
   * "dishes_id":"b9591534-59d2-46f9-9fe3-589d87ebfe23",
   * "upload_url":"/GrogshopUpload/dishes/20160811085148144mdj.jpg","list":null},{"tagID":"2",
   * "type":null,"dishes_name":"玉米汁","dishes_price":"48.00",
   * "dishes_id":"ae73d4fe-6b27-45be-b2af-d655ead940f6",
   * "upload_url":"/GrogshopUpload/dishes/20160811092807241ymz.jpg","list":null},{"tagID":"11",
   * "type":null,"dishes_name":"玉米汁","dishes_price":"48.00",
   * "dishes_id":"ae73d4fe-6b27-45be-b2af-d655ead940f6",
   * "upload_url":"/GrogshopUpload/dishes/20160811092807241ymz.jpg","list":null},{"tagID":"2",
   * "type":null,"dishes_name":"紫薯汁","dishes_price":"48.00",
   * "dishes_id":"5f28cb48-9cad-4ee1-97f9-a45e97262d26",
   * "upload_url":"/GrogshopUpload/dishes/20160811092923422zsz.JPG","list":null},{"tagID":"11",
   * "type":null,"dishes_name":"紫薯汁","dishes_price":"48.00",
   * "dishes_id":"5f28cb48-9cad-4ee1-97f9-a45e97262d26",
   * "upload_url":"/GrogshopUpload/dishes/20160811092923422zsz.JPG","list":null},{"tagID":"2",
   * "type":null,"dishes_name":"西瓜汁","dishes_price":"48.00",
   * "dishes_id":"854e984d-0f4a-48a8-97e4-ada368e04196",
   * "upload_url":"/GrogshopUpload/dishes/20160811092712413xgz.jpg","list":null},{"tagID":"11",
   * "type":null,"dishes_name":"西瓜汁","dishes_price":"48.00",
   * "dishes_id":"854e984d-0f4a-48a8-97e4-ada368e04196",
   * "upload_url":"/GrogshopUpload/dishes/20160811092712413xgz.jpg","list":null},{"tagID":"2",
   * "type":null,"dishes_name":"铁板鱼扣","dishes_price":"42.00",
   * "dishes_id":"0c94f372-e72c-4e74-946b-d722a7ecc984",
   * "upload_url":"/GrogshopUpload/dishes/20160811112232131tbyk.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"铁板鱼扣","dishes_price":"42.00",
   * "dishes_id":"0c94f372-e72c-4e74-946b-d722a7ecc984",
   * "upload_url":"/GrogshopUpload/dishes/20160811112232131tbyk.jpg","list":null},{"tagID":"2",
   * "type":null,"dishes_name":"铁板海鲜粉丝 ","dishes_price":"32.00",
   * "dishes_id":"35c525e4-5617-4102-81e8-ce27656fdb62",
   * "upload_url":"/GrogshopUpload/dishes/2016081111190395tbhxfs.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"铁板海鲜粉丝 ","dishes_price":"32.00",
   * "dishes_id":"35c525e4-5617-4102-81e8-ce27656fdb62",
   * "upload_url":"/GrogshopUpload/dishes/2016081111190395tbhxfs.jpg","list":null},
   * {"tagID":"2","type":null,"dishes_name":"蒸饺","dishes_price":"22.00",
   * "dishes_id":"4282c257-dcde-49e7-bbb6-24c512a9c67a",
   * "upload_url":"/GrogshopUpload/dishes/2016081115570353zj.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"蒸饺","dishes_price":"22.00",
   * "dishes_id":"4282c257-dcde-49e7-bbb6-24c512a9c67a",
   * "upload_url":"/GrogshopUpload/dishes/2016081115570353zj.jpg","list":null},{"tagID":"2",
   * "type":null,"dishes_name":"剁椒皮蛋","dishes_price":"12.60",
   * "dishes_id":"43522fc1-ccbd-474e-b813-ce7f0d37e831",
   * "upload_url":"/GrogshopUpload/dishes/201608110843022djpd.jpg","list":null},{"tagID":"9",
   * "type":null,"dishes_name":"剁椒皮蛋","dishes_price":"12.60",
   * "dishes_id":"43522fc1-ccbd-474e-b813-ce7f0d37e831",
   * "upload_url":"/GrogshopUpload/dishes/201608110843022djpd.jpg","list":null},{"tagID":"2",
   * "type":null,"dishes_name":"松子玉米","dishes_price":"18.00",
   * "dishes_id":"523eba98-03df-4311-9b7e-da84264e289f",
   * "upload_url":"/GrogshopUpload/dishes/20160811110711407szym.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"松子玉米","dishes_price":"18.00",
   * "dishes_id":"523eba98-03df-4311-9b7e-da84264e289f",
   * "upload_url":"/GrogshopUpload/dishes/20160811110711407szym.jpg","list":null},{"tagID":"2",
   * "type":null,"dishes_name":"干锅茶树菇","dishes_price":"19.00",
   * "dishes_id":"529be5d5-ac2d-4955-a406-1ddb0ec8122f",
   * "upload_url":"/GrogshopUpload/dishes/20160811094212638ggcsk.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"干锅茶树菇","dishes_price":"19.00",
   * "dishes_id":"529be5d5-ac2d-4955-a406-1ddb0ec8122f",
   * "upload_url":"/GrogshopUpload/dishes/20160811094212638ggcsk.jpg","list":null},
   * {"tagID":"2","type":null,"dishes_name":"窝窝头","dishes_price":"29.00",
   * "dishes_id":"55530093-f477-4dd0-bbda-865204533aae",
   * "upload_url":"/GrogshopUpload/dishes/20160811112347890wwt.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"窝窝头","dishes_price":"29.00",
   * "dishes_id":"55530093-f477-4dd0-bbda-865204533aae",
   * "upload_url":"/GrogshopUpload/dishes/20160811112347890wwt.jpg","list":null},{"tagID":"2",
   * "type":null,"dishes_name":"苋菜","dishes_price":"18.00",
   * "dishes_id":"55a4e7f5-3c85-432a-88b6-6ab63382bc1f",
   * "upload_url":"/GrogshopUpload/dishes/2016081111245612wc.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"苋菜","dishes_price":"18.00",
   * "dishes_id":"55a4e7f5-3c85-432a-88b6-6ab63382bc1f",
   * "upload_url":"/GrogshopUpload/dishes/2016081111245612wc.jpg","list":null},{"tagID":"2",
   * "type":null,"dishes_name":"上汤娃娃菜","dishes_price":"28.00",
   * "dishes_id":"5b6b8598-ebe9-4893-80e1-676da77df865",
   * "upload_url":"/GrogshopUpload/dishes/20160811104517871stwwc.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"上汤娃娃菜","dishes_price":"28.00",
   * "dishes_id":"5b6b8598-ebe9-4893-80e1-676da77df865",
   * "upload_url":"/GrogshopUpload/dishes/20160811104517871stwwc.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"青椒炒肉丝 ","dishes_price":"22.00",
   * "dishes_id":"00b4a4c6-b848-41db-b7dc-972d6651ead2",
   * "upload_url":"/GrogshopUpload/dishes/20160811092000716qjcrs.jpg","list":null},
   * {"tagID":"13","type":null,"dishes_name":"青椒炒肉丝 ","dishes_price":"22.00",
   * "dishes_id":"00b4a4c6-b848-41db-b7dc-972d6651ead2",
   * "upload_url":"/GrogshopUpload/dishes/20160811092000716qjcrs.jpg","list":null},
   * {"tagID":"3","type":null,"dishes_name":"小鱼贴饼","dishes_price":"48.00",
   * "dishes_id":"0644e451-a92b-4eb3-8d21-63268ac4114a",
   * "upload_url":"/GrogshopUpload/dishes/20160811112641699xytb.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"小鱼贴饼","dishes_price":"48.00",
   * "dishes_id":"0644e451-a92b-4eb3-8d21-63268ac4114a",
   * "upload_url":"/GrogshopUpload/dishes/20160811112641699xytb.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"扑克","dishes_price":"10.00",
   * "dishes_id":"08d8a4b3-c063-4efa-95c5-b676c35d6e07",
   * "upload_url":"/GrogshopUpload/dishes/20160811091901931pk.jpg","list":null},{"tagID":"13",
   * "type":null,"dishes_name":"扑克","dishes_price":"10.00",
   * "dishes_id":"08d8a4b3-c063-4efa-95c5-b676c35d6e07",
   * "upload_url":"/GrogshopUpload/dishes/20160811091901931pk.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"腌菜小肠节","dishes_price":"36.00",
   * "dishes_id":"11a06895-3b0a-4ed8-834d-72da98b7a76b",
   * "upload_url":"/GrogshopUpload/dishes/20160811113038340ycxcj.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"腌菜小肠节","dishes_price":"36.00",
   * "dishes_id":"11a06895-3b0a-4ed8-834d-72da98b7a76b",
   * "upload_url":"/GrogshopUpload/dishes/20160811113038340ycxcj.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"餐具一元","dishes_price":"1.00",
   * "dishes_id":"12dd0f60-712d-46a9-87d6-1efb28d8ad4f",
   * "upload_url":"/GrogshopUpload/dishes/20160811090229575cj.jpg","list":null},{"tagID":"13",
   * "type":null,"dishes_name":"餐具一元","dishes_price":"1.00",
   * "dishes_id":"12dd0f60-712d-46a9-87d6-1efb28d8ad4f",
   * "upload_url":"/GrogshopUpload/dishes/20160811090229575cj.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"青菜烧肥肠","dishes_price":"48.00",
   * "dishes_id":"175c0e0b-6082-457f-bba2-b936f67724f9",
   * "upload_url":"/GrogshopUpload/dishes/20160811103650290qcfc.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"青菜烧肥肠","dishes_price":"48.00",
   * "dishes_id":"175c0e0b-6082-457f-bba2-b936f67724f9",
   * "upload_url":"/GrogshopUpload/dishes/20160811103650290qcfc.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"鱼头","dishes_price":"68.00",
   * "dishes_id":"17a50d54-a9a7-4e55-9d99-84ab169eb000",
   * "upload_url":"/GrogshopUpload/dishes/20160811155313940yt.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"鱼头","dishes_price":"68.00",
   * "dishes_id":"17a50d54-a9a7-4e55-9d99-84ab169eb000",
   * "upload_url":"/GrogshopUpload/dishes/20160811155313940yt.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"青菜牛肉","dishes_price":"44.80",
   * "dishes_id":"17c64146-f6b5-4909-853d-13cd03b65d7a",
   * "upload_url":"/GrogshopUpload/dishes/20160811103515506qcnr.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"青菜牛肉","dishes_price":"44.80",
   * "dishes_id":"17c64146-f6b5-4909-853d-13cd03b65d7a",
   * "upload_url":"/GrogshopUpload/dishes/20160811103515506qcnr.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"糯米丸子烧排骨","dishes_price":"36.80",
   * "dishes_id":"1b2cb804-58d7-4ec3-8954-9eb4c597d286",
   * "upload_url":"/GrogshopUpload/dishes/20160811101651164lmwzspg.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"糯米丸子烧排骨","dishes_price":"36.80",
   * "dishes_id":"1b2cb804-58d7-4ec3-8954-9eb4c597d286",
   * "upload_url":"/GrogshopUpload/dishes/20160811101651164lmwzspg.jpg","list":null},
   * {"tagID":"3","type":null,"dishes_name":"水煮鸭血腰润","dishes_price":"38.00",
   * "dishes_id":"1c2e1fa7-9d56-42d1-8441-2084a962f0af",
   * "upload_url":"/GrogshopUpload/dishes/20160811110030219szyxyr.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"水煮鸭血腰润","dishes_price":"38.00",
   * "dishes_id":"1c2e1fa7-9d56-42d1-8441-2084a962f0af",
   * "upload_url":"/GrogshopUpload/dishes/20160811110030219szyxyr.jpg","list":null},
   * {"tagID":"3","type":null,"dishes_name":"拌海带丝","dishes_price":"8.00",
   * "dishes_id":"22c88da9-222e-43b6-82b1-c418b417323e",
   * "upload_url":"/GrogshopUpload/dishes/20160811084010172bhds.jpg","list":null},{"tagID":"9",
   * "type":null,"dishes_name":"拌海带丝","dishes_price":"8.00",
   * "dishes_id":"22c88da9-222e-43b6-82b1-c418b417323e",
   * "upload_url":"/GrogshopUpload/dishes/20160811084010172bhds.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"葱油蚕豆","dishes_price":"9.60",
   * "dishes_id":"232a9815-a807-4149-9233-0738c4bc7f84",
   * "upload_url":"/GrogshopUpload/dishes/20160811084134147cycd.jpg","list":null},{"tagID":"9",
   * "type":null,"dishes_name":"葱油蚕豆","dishes_price":"9.60",
   * "dishes_id":"232a9815-a807-4149-9233-0738c4bc7f84",
   * "upload_url":"/GrogshopUpload/dishes/20160811084134147cycd.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"豆腐脑","dishes_price":"16.00",
   * "dishes_id":"26304412-b8ee-46fb-8d85-314db259f3df",
   * "upload_url":"/GrogshopUpload/dishes/20160811094005894dfn.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"豆腐脑","dishes_price":"16.00",
   * "dishes_id":"26304412-b8ee-46fb-8d85-314db259f3df",
   * "upload_url":"/GrogshopUpload/dishes/20160811094005894dfn.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"菊叶蛋汤 ","dishes_price":"16.00",
   * "dishes_id":"377fae0d-beff-4809-a4f9-ece7ae2c94e3",
   * "upload_url":"/GrogshopUpload/dishes/20160811091449329jydt.jpg","list":null},
   * {"tagID":"13","type":null,"dishes_name":"菊叶蛋汤 ","dishes_price":"16.00",
   * "dishes_id":"377fae0d-beff-4809-a4f9-ece7ae2c94e3",
   * "upload_url":"/GrogshopUpload/dishes/20160811091449329jydt.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"桂鱼","dishes_price":"46.00",
   * "dishes_id":"39b56577-722a-4131-8e37-3c8fb2c9ba74",
   * "upload_url":"/GrogshopUpload/dishes/20160811094855960gy.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"桂鱼","dishes_price":"46.00",
   * "dishes_id":"39b56577-722a-4131-8e37-3c8fb2c9ba74",
   * "upload_url":"/GrogshopUpload/dishes/20160811094855960gy.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"青菜豆皮","dishes_price":"29.00",
   * "dishes_id":"3eb2a6ca-32dd-426b-a4cf-db88e483427c",
   * "upload_url":"/GrogshopUpload/dishes/20160811103329798qcdp.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"青菜豆皮","dishes_price":"29.00",
   * "dishes_id":"3eb2a6ca-32dd-426b-a4cf-db88e483427c",
   * "upload_url":"/GrogshopUpload/dishes/20160811103329798qcdp.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"干锅莴笋片","dishes_price":"17.40",
   * "dishes_id":"3ee60f46-c174-4689-a351-ef1027ef9b20",
   * "upload_url":"/GrogshopUpload/dishes/20160811094744122ggwsp.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"干锅莴笋片","dishes_price":"17.40",
   * "dishes_id":"3ee60f46-c174-4689-a351-ef1027ef9b20",
   * "upload_url":"/GrogshopUpload/dishes/20160811094744122ggwsp.jpg","list":null},
   * {"tagID":"3","type":null,"dishes_name":"千叶豆腐","dishes_price":"21.60",
   * "dishes_id":"3f033d3f-b4c9-4c9c-9b4e-7a30e0d56220",
   * "upload_url":"/GrogshopUpload/dishes/20160811103008984qydf.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"千叶豆腐","dishes_price":"21.60",
   * "dishes_id":"3f033d3f-b4c9-4c9c-9b4e-7a30e0d56220",
   * "upload_url":"/GrogshopUpload/dishes/20160811103008984qydf.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"私家牛筋牛腩 ","dishes_price":"68.00",
   * "dishes_id":"421e8965-f9ba-43e8-8522-b1e083216178",
   * "upload_url":"/GrogshopUpload/dishes/20160811110552576sjnjnl.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"私家牛筋牛腩 ","dishes_price":"68.00",
   * "dishes_id":"421e8965-f9ba-43e8-8522-b1e083216178",
   * "upload_url":"/GrogshopUpload/dishes/20160811110552576sjnjnl.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"空心菜","dishes_price":"18.00",
   * "dishes_id":"487ff206-3ba3-4ca5-bcdf-3a33ecac5c9f",
   * "upload_url":"/GrogshopUpload/dishes/20160811100730688kxc.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"空心菜","dishes_price":"18.00",
   * "dishes_id":"487ff206-3ba3-4ca5-bcdf-3a33ecac5c9f",
   * "upload_url":"/GrogshopUpload/dishes/20160811100730688kxc.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"蒜泥龙虾","dishes_price":"58.00",
   * "dishes_id":"4f991fc7-7b35-430f-9326-2feb4debc6b7",
   * "upload_url":"/GrogshopUpload/dishes/2016081111141799snlx.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"蒜泥龙虾","dishes_price":"58.00",
   * "dishes_id":"4f991fc7-7b35-430f-9326-2feb4debc6b7",
   * "upload_url":"/GrogshopUpload/dishes/2016081111141799snlx.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"油焖茄子","dishes_price":"22.00",
   * "dishes_id":"4fdde5dc-0459-427b-a8ef-00b0a41ef8be",
   * "upload_url":"/GrogshopUpload/dishes/20160811143918365ymqz.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"油焖茄子","dishes_price":"22.00",
   * "dishes_id":"4fdde5dc-0459-427b-a8ef-00b0a41ef8be",
   * "upload_url":"/GrogshopUpload/dishes/20160811143918365ymqz.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"鸭架青菜泡饭","dishes_price":"16.00",
   * "dishes_id":"517dbce4-7321-4f7e-a568-5cd7ec8c97ab",
   * "upload_url":"/GrogshopUpload/dishes/20160811092446655yjqcbf.jpg","list":null},
   * {"tagID":"13","type":null,"dishes_name":"鸭架青菜泡饭","dishes_price":"16.00",
   * "dishes_id":"517dbce4-7321-4f7e-a568-5cd7ec8c97ab",
   * "upload_url":"/GrogshopUpload/dishes/20160811092446655yjqcbf.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"茄子烧豇豆","dishes_price":"22.00",
   * "dishes_id":"522b69e8-7908-4fec-b535-3d7d33c9720e",
   * "upload_url":"/GrogshopUpload/dishes/20160811103135608qzshd.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"茄子烧豇豆","dishes_price":"22.00",
   * "dishes_id":"522b69e8-7908-4fec-b535-3d7d33c9720e",
   * "upload_url":"/GrogshopUpload/dishes/20160811103135608qzshd.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"酱","dishes_price":"2.00",
   * "dishes_id":"5424a98d-f940-4f53-a085-658040ef1c68",
   * "upload_url":"/GrogshopUpload/dishes/2016081109123624jjj.jpg","list":null},{"tagID":"13",
   * "type":null,"dishes_name":"酱","dishes_price":"2.00",
   * "dishes_id":"5424a98d-f940-4f53-a085-658040ef1c68",
   * "upload_url":"/GrogshopUpload/dishes/2016081109123624jjj.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"十三香龙虾","dishes_price":"58.00",
   * "dishes_id":"5771fa75-05a2-4c0f-9809-d4f629ee171c",
   * "upload_url":"/GrogshopUpload/dishes/20160811104659294ssxlx.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"十三香龙虾","dishes_price":"58.00",
   * "dishes_id":"5771fa75-05a2-4c0f-9809-d4f629ee171c",
   * "upload_url":"/GrogshopUpload/dishes/20160811104659294ssxlx.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"西红柿蛋汤","dishes_price":"14.00",
   * "dishes_id":"5a7820c0-5fa6-4292-85b6-ff730c03be3a",
   * "upload_url":"/GrogshopUpload/dishes/2016081109224270shsdt.jpg","list":null},
   * {"tagID":"13","type":null,"dishes_name":"西红柿蛋汤","dishes_price":"14.00",
   * "dishes_id":"5a7820c0-5fa6-4292-85b6-ff730c03be3a",
   * "upload_url":"/GrogshopUpload/dishes/2016081109224270shsdt.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"鸭架青菜面疙瘩 ","dishes_price":"18.00",
   * "dishes_id":"5ec4fa8b-8e9b-4a3e-a284-a3d1c9e1a4cb",
   * "upload_url":"/GrogshopUpload/dishes/20160811092353947yjqcmgd.jpg","list":null},
   * {"tagID":"13","type":null,"dishes_name":"鸭架青菜面疙瘩 ","dishes_price":"18.00",
   * "dishes_id":"5ec4fa8b-8e9b-4a3e-a284-a3d1c9e1a4cb",
   * "upload_url":"/GrogshopUpload/dishes/20160811092353947yjqcmgd.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"清蒸松鸡 ","dishes_price":"39.00",
   * "dishes_id":"60bbc2b0-f8ce-4e76-8ce2-ffb232aacdcf",
   * "upload_url":"/GrogshopUpload/dishes/20160811103811244qcsj.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"清蒸松鸡 ","dishes_price":"39.00",
   * "dishes_id":"60bbc2b0-f8ce-4e76-8ce2-ffb232aacdcf",
   * "upload_url":"/GrogshopUpload/dishes/20160811103811244qcsj.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"萝卜丝烧仔鸡","dishes_price":"25.20",
   * "dishes_id":"61ff17df-d863-4e43-900a-b55fa2ec0652",
   * "upload_url":"/GrogshopUpload/dishes/2016081110131929lbsszj.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"萝卜丝烧仔鸡","dishes_price":"25.20",
   * "dishes_id":"61ff17df-d863-4e43-900a-b55fa2ec0652",
   * "upload_url":"/GrogshopUpload/dishes/2016081110131929lbsszj.jpg","list":null},
   * {"tagID":"3","type":null,"dishes_name":"汽锅一品鲜 ","dishes_price":"75.60",
   * "dishes_id":"632f6187-4837-4321-afc7-9e6e7dd12f93",
   * "upload_url":"/GrogshopUpload/dishes/20160811102835647qgybx.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"汽锅一品鲜 ","dishes_price":"75.60",
   * "dishes_id":"632f6187-4837-4321-afc7-9e6e7dd12f93",
   * "upload_url":"/GrogshopUpload/dishes/20160811102835647qgybx.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"鱼香茄子","dishes_price":"22.00",
   * "dishes_id":"65479d5a-6fbd-4dcf-b990-8cf2dec4c9bf",
   * "upload_url":"/GrogshopUpload/dishes/20160811155437687yxqz.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"鱼香茄子","dishes_price":"22.00",
   * "dishes_id":"65479d5a-6fbd-4dcf-b990-8cf2dec4c9bf",
   * "upload_url":"/GrogshopUpload/dishes/20160811155437687yxqz.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"丝瓜炒鸡蛋","dishes_price":"22.00",
   * "dishes_id":"69a76133-4661-468f-a9bc-7dcce8c52b1d",
   * "upload_url":"/GrogshopUpload/dishes/20160811110229489sgcjd.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"丝瓜炒鸡蛋","dishes_price":"22.00",
   * "dishes_id":"69a76133-4661-468f-a9bc-7dcce8c52b1d",
   * "upload_url":"/GrogshopUpload/dishes/20160811110229489sgcjd.jpg","list":null},
   * {"tagID":"3","type":null,"dishes_name":"凤爪 ","dishes_price":"8.00",
   * "dishes_id":"69d29dc3-db5e-4b9b-8c02-28a1e5c19b8d",
   * "upload_url":"/GrogshopUpload/dishes/20160811084354664fz.jpg","list":null},{"tagID":"9",
   * "type":null,"dishes_name":"凤爪 ","dishes_price":"8.00",
   * "dishes_id":"69d29dc3-db5e-4b9b-8c02-28a1e5c19b8d",
   * "upload_url":"/GrogshopUpload/dishes/20160811084354664fz.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"葱四元每份","dishes_price":"4.00",
   * "dishes_id":"6e054999-8271-48d8-984f-7d5f8b379806",
   * "upload_url":"/GrogshopUpload/dishes/2016081109035284ccc.jpg","list":null},{"tagID":"13",
   * "type":null,"dishes_name":"葱四元每份","dishes_price":"4.00",
   * "dishes_id":"6e054999-8271-48d8-984f-7d5f8b379806",
   * "upload_url":"/GrogshopUpload/dishes/2016081109035284ccc.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"鸡汤","dishes_price":"10.00",
   * "dishes_id":"6ffd8cad-7dd8-4259-ac75-a28b49b50bb8",
   * "upload_url":"/GrogshopUpload/dishes/20160811091124502jt.jpg","list":null},{"tagID":"13",
   * "type":null,"dishes_name":"鸡汤","dishes_price":"10.00",
   * "dishes_id":"6ffd8cad-7dd8-4259-ac75-a28b49b50bb8",
   * "upload_url":"/GrogshopUpload/dishes/20160811091124502jt.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"酱鸭头三元每只","dishes_price":"12.00",
   * "dishes_id":"70dc5731-34cd-4de2-b5c4-5fe896630435",
   * "upload_url":"/GrogshopUpload/dishes/20160811084526302jyd.jpg","list":null},{"tagID":"9",
   * "type":null,"dishes_name":"酱鸭头三元每只","dishes_price":"12.00",
   * "dishes_id":"70dc5731-34cd-4de2-b5c4-5fe896630435",
   * "upload_url":"/GrogshopUpload/dishes/20160811084526302jyd.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"口水鸡","dishes_price":"28.00",
   * "dishes_id":"7239f219-ba4a-4f8e-9adc-7bc2e453db23",
   * "upload_url":"/GrogshopUpload/dishes/20160811084715291ksj.jpg","list":null},{"tagID":"9",
   * "type":null,"dishes_name":"口水鸡","dishes_price":"28.00",
   * "dishes_id":"7239f219-ba4a-4f8e-9adc-7bc2e453db23",
   * "upload_url":"/GrogshopUpload/dishes/20160811084715291ksj.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"酸汤肥牛","dishes_price":"42.00",
   * "dishes_id":"732e4f64-c566-4981-957b-e8f0becffcec",
   * "upload_url":"/GrogshopUpload/dishes/20160811111236956scfn.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"酸汤肥牛","dishes_price":"42.00",
   * "dishes_id":"732e4f64-c566-4981-957b-e8f0becffcec",
   * "upload_url":"/GrogshopUpload/dishes/20160811111236956scfn.jpg","list":null},{"tagID":"2",
   * "type":null,"dishes_name":"铁板鱿鱼须 ","dishes_price":"42.00",
   * "dishes_id":"754f4d8a-0d94-452f-b7df-c95981d17424",
   * "upload_url":"/GrogshopUpload/dishes/20160811112123420tbyyx.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"铁板鱿鱼须 ","dishes_price":"42.00",
   * "dishes_id":"754f4d8a-0d94-452f-b7df-c95981d17424",
   * "upload_url":"/GrogshopUpload/dishes/20160811112123420tbyyx.jpg","list":null},
   * {"tagID":"2","type":null,"dishes_name":"铁板牛仔骨","dishes_price":"78.00",
   * "dishes_id":"756499cb-a785-41d2-aec5-daaee5b9a59d",
   * "upload_url":"/GrogshopUpload/dishes/20160811112009990tbnzg.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"铁板牛仔骨","dishes_price":"78.00",
   * "dishes_id":"756499cb-a785-41d2-aec5-daaee5b9a59d",
   * "upload_url":"/GrogshopUpload/dishes/20160811112009990tbnzg.jpg","list":null},
   * {"tagID":"3","type":null,"dishes_name":"手工狮子头","dishes_price":"68.00",
   * "dishes_id":"757c57e0-988a-4e42-969b-6249b4d30f33",
   * "upload_url":"/GrogshopUpload/dishes/20160811105610740sgszt.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"手工狮子头","dishes_price":"68.00",
   * "dishes_id":"757c57e0-988a-4e42-969b-6249b4d30f33",
   * "upload_url":"/GrogshopUpload/dishes/20160811105610740sgszt.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"碳烤青鱼","dishes_price":"59.00",
   * "dishes_id":"76909619-8b7a-4120-a7d6-ff8a3a864388",
   * "upload_url":"/GrogshopUpload/dishes/20160811111636379tkqy.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"碳烤青鱼","dishes_price":"59.00",
   * "dishes_id":"76909619-8b7a-4120-a7d6-ff8a3a864388",
   * "upload_url":"/GrogshopUpload/dishes/20160811111636379tkqy.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"清蒸松鼠鱼 ","dishes_price":"63.00",
   * "dishes_id":"79100679-fc4b-4083-b383-c8a43eaea9aa",
   * "upload_url":"/GrogshopUpload/dishes/20160811103940392qcssy.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"清蒸松鼠鱼 ","dishes_price":"63.00",
   * "dishes_id":"79100679-fc4b-4083-b383-c8a43eaea9aa",
   * "upload_url":"/GrogshopUpload/dishes/20160811103940392qcssy.jpg","list":null},
   * {"tagID":"3","type":null,"dishes_name":"双臭煲 ","dishes_price":"28.00",
   * "dishes_id":"7b530490-6718-49d7-a973-c6799be54eda",
   * "upload_url":"/GrogshopUpload/dishes/20160811105918265scb.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"双臭煲 ","dishes_price":"28.00",
   * "dishes_id":"7b530490-6718-49d7-a973-c6799be54eda",
   * "upload_url":"/GrogshopUpload/dishes/20160811105918265scb.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"蒜蓉虾","dishes_price":"58.00",
   * "dishes_id":"7b626ba8-87cc-4f90-a84e-839ed43affeb",
   * "upload_url":"/GrogshopUpload/dishes/20160811111523441srx.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"蒜蓉虾","dishes_price":"58.00",
   * "dishes_id":"7b626ba8-87cc-4f90-a84e-839ed43affeb",
   * "upload_url":"/GrogshopUpload/dishes/20160811111523441srx.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"地锅鸡","dishes_price":"22.80",
   * "dishes_id":"7ea37196-3828-482f-97ce-84bc3948a28e",
   * "upload_url":"/GrogshopUpload/dishes/20160811093855737dgj.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"地锅鸡","dishes_price":"22.80",
   * "dishes_id":"7ea37196-3828-482f-97ce-84bc3948a28e",
   * "upload_url":"/GrogshopUpload/dishes/20160811093855737dgj.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"毛巾 ","dishes_price":"1.00",
   * "dishes_id":"7ffa73f1-970b-4714-8b04-191740faed51",
   * "upload_url":"/GrogshopUpload/dishes/2016081109174058mj.jpg","list":null},{"tagID":"13",
   * "type":null,"dishes_name":"毛巾 ","dishes_price":"1.00",
   * "dishes_id":"7ffa73f1-970b-4714-8b04-191740faed51",
   * "upload_url":"/GrogshopUpload/dishes/2016081109174058mj.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"万万的新菜","dishes_price":"10.80",
   * "dishes_id":"80399496-ef28-47d9-ac00-b321a100ca0f",
   * "upload_url":"/GrogshopUpload/dishes/20160830110349883577da82c5d99d.jpg","list":null},
   * {"tagID":"12","type":null,"dishes_name":"万万的新菜","dishes_price":"10.80",
   * "dishes_id":"80399496-ef28-47d9-ac00-b321a100ca0f",
   * "upload_url":"/GrogshopUpload/dishes/20160830110349883577da82c5d99d.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"手撕包菜","dishes_price":"18.00",
   * "dishes_id":"8124b8c1-6c61-41f5-984b-737a47fb551a",
   * "upload_url":"/GrogshopUpload/dishes/20160811105730188ssbc.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"手撕包菜","dishes_price":"18.00",
   * "dishes_id":"8124b8c1-6c61-41f5-984b-737a47fb551a",
   * "upload_url":"/GrogshopUpload/dishes/20160811105730188ssbc.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"石锅跳水蛙","dishes_price":"46.40",
   * "dishes_id":"82f0a789-2523-4f6f-8e19-05b6f98738f4",
   * "upload_url":"/GrogshopUpload/dishes/2016081110524567sgtsw.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"石锅跳水蛙","dishes_price":"46.40",
   * "dishes_id":"82f0a789-2523-4f6f-8e19-05b6f98738f4",
   * "upload_url":"/GrogshopUpload/dishes/2016081110524567sgtsw.jpg","list":null},{"tagID":"2",
   * "type":null,"dishes_name":"扇贝","dishes_price":"9.00",
   * "dishes_id":"87405d8d-e8d5-47c1-87c2-f142f180a245",
   * "upload_url":"/GrogshopUpload/dishes/20160811104051896sb.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"扇贝","dishes_price":"9.00",
   * "dishes_id":"87405d8d-e8d5-47c1-87c2-f142f180a245",
   * "upload_url":"/GrogshopUpload/dishes/20160811104051896sb.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"酸菜腰片 ","dishes_price":"26.00",
   * "dishes_id":"8954dd1c-70ce-4a67-bfd4-8ca8a92281c9",
   * "upload_url":"/GrogshopUpload/dishes/20160811111037955scyp.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"酸菜腰片 ","dishes_price":"26.00",
   * "dishes_id":"8954dd1c-70ce-4a67-bfd4-8ca8a92281c9",
   * "upload_url":"/GrogshopUpload/dishes/20160811111037955scyp.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"烤鸭二十九元半只","dishes_price":"58.00",
   * "dishes_id":"8ce000f8-cc00-4da5-82fc-c77b420ff6cf",
   * "upload_url":"/GrogshopUpload/dishes/20160811091637674ky.jpg","list":null},{"tagID":"13",
   * "type":null,"dishes_name":"烤鸭二十九元半只","dishes_price":"58.00",
   * "dishes_id":"8ce000f8-cc00-4da5-82fc-c77b420ff6cf",
   * "upload_url":"/GrogshopUpload/dishes/20160811091637674ky.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"野水芹炒肉丝","dishes_price":"28.00",
   * "dishes_id":"8db171a2-db9d-4594-9ff8-550baed1ea9c",
   * "upload_url":"/GrogshopUpload/dishes/20160811132916444ysqcrs.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"野水芹炒肉丝","dishes_price":"28.00",
   * "dishes_id":"8db171a2-db9d-4594-9ff8-550baed1ea9c",
   * "upload_url":"/GrogshopUpload/dishes/20160811132916444ysqcrs.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"椒盐虾","dishes_price":"34.80",
   * "dishes_id":"8e9a1d6b-d21a-49df-9018-d68a7c76555c",
   * "upload_url":"/GrogshopUpload/dishes/20160811095950540jyx.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"椒盐虾","dishes_price":"34.80",
   * "dishes_id":"8e9a1d6b-d21a-49df-9018-d68a7c76555c",
   * "upload_url":"/GrogshopUpload/dishes/20160811095950540jyx.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"手工春卷","dishes_price":"29.00",
   * "dishes_id":"9014ed6e-ff05-4013-ba35-f81bb41e7306",
   * "upload_url":"/GrogshopUpload/dishes/2016081110540739sgcj.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"手工春卷","dishes_price":"29.00",
   * "dishes_id":"9014ed6e-ff05-4013-ba35-f81bb41e7306",
   * "upload_url":"/GrogshopUpload/dishes/2016081110540739sgcj.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"调料每套12元","dishes_price":"12.00",
   * "dishes_id":"90a704ce-59c4-40fe-9313-1bf9da64ca7a",
   * "upload_url":"/GrogshopUpload/dishes/20160811092115670tl.jpg","list":null},{"tagID":"13",
   * "type":null,"dishes_name":"调料每套12元","dishes_price":"12.00",
   * "dishes_id":"90a704ce-59c4-40fe-9313-1bf9da64ca7a",
   * "upload_url":"/GrogshopUpload/dishes/20160811092115670tl.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"蚝油生菜","dishes_price":"22.00",
   * "dishes_id":"930e0ad4-14e5-4221-88b8-988b601e3349",
   * "upload_url":"/GrogshopUpload/dishes/20160811090737300mysc.jpg","list":null},
   * {"tagID":"13","type":null,"dishes_name":"蚝油生菜","dishes_price":"22.00",
   * "dishes_id":"930e0ad4-14e5-4221-88b8-988b601e3349",
   * "upload_url":"/GrogshopUpload/dishes/20160811090737300mysc.jpg","list":null},{"tagID":"2",
   * "type":null,"dishes_name":"蟹粉鱼圆锅仔","dishes_price":"39.00",
   * "dishes_id":"966192f2-647c-4a87-aec4-16eda80e7fd5",
   * "upload_url":"/GrogshopUpload/dishes/20160811112808524xfyygz.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"蟹粉鱼圆锅仔","dishes_price":"39.00",
   * "dishes_id":"966192f2-647c-4a87-aec4-16eda80e7fd5",
   * "upload_url":"/GrogshopUpload/dishes/20160811112808524xfyygz.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"饼六元每份","dishes_price":"6.00",
   * "dishes_id":"9a57a31b-ba87-4327-9fa1-6f6c7c4db20d",
   * "upload_url":"/GrogshopUpload/dishes/20160811090010859blymf.jpg","list":null},
   * {"tagID":"13","type":null,"dishes_name":"饼六元每份","dishes_price":"6.00",
   * "dishes_id":"9a57a31b-ba87-4327-9fa1-6f6c7c4db20d",
   * "upload_url":"/GrogshopUpload/dishes/20160811090010859blymf.jpg","list":null},
   * {"tagID":"3","type":null,"dishes_name":"石锅黄牛肉","dishes_price":"38.00",
   * "dishes_id":"9b80477b-2148-4281-a3f8-6e1a4821c74e",
   * "upload_url":"/GrogshopUpload/dishes/20160811105033240sghnr.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"石锅黄牛肉","dishes_price":"38.00",
   * "dishes_id":"9b80477b-2148-4281-a3f8-6e1a4821c74e",
   * "upload_url":"/GrogshopUpload/dishes/20160811105033240sghnr.jpg","list":null},
   * {"tagID":"3","type":null,"dishes_name":"凉拌木耳","dishes_price":"8.00",
   * "dishes_id":"9d8bcf3b-7d5e-4068-8c2b-d701e1f96a33",
   * "upload_url":"/GrogshopUpload/dishes/20160811084820512lbme.jpg","list":null},{"tagID":"9",
   * "type":null,"dishes_name":"凉拌木耳","dishes_price":"8.00",
   * "dishes_id":"9d8bcf3b-7d5e-4068-8c2b-d701e1f96a33",
   * "upload_url":"/GrogshopUpload/dishes/20160811084820512lbme.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"凉皮 ","dishes_price":"6.00",
   * "dishes_id":"9dbee9f9-2611-473c-8193-4fe181514954",
   * "upload_url":"/GrogshopUpload/dishes/20160811084925953lp.jpg","list":null},{"tagID":"9",
   * "type":null,"dishes_name":"凉皮 ","dishes_price":"6.00",
   * "dishes_id":"9dbee9f9-2611-473c-8193-4fe181514954",
   * "upload_url":"/GrogshopUpload/dishes/20160811084925953lp.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"辣炒花甲","dishes_price":"28.80",
   * "dishes_id":"a0e0a45e-1c32-47dc-9708-3db3788c1986",
   * "upload_url":"/GrogshopUpload/dishes/20160811101158378ljhj.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"辣炒花甲","dishes_price":"28.80",
   * "dishes_id":"a0e0a45e-1c32-47dc-9708-3db3788c1986",
   * "upload_url":"/GrogshopUpload/dishes/20160811101158378ljhj.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"爆炒肥肠","dishes_price":"33.60",
   * "dishes_id":"a50b8253-31a0-4a45-ba20-b654ade9dc61",
   * "upload_url":"/GrogshopUpload/dishes/20160811093353870bcfc.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"爆炒肥肠","dishes_price":"33.60",
   * "dishes_id":"a50b8253-31a0-4a45-ba20-b654ade9dc61",
   * "upload_url":"/GrogshopUpload/dishes/20160811093353870bcfc.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"韭菜蚬肉 ","dishes_price":"19.60",
   * "dishes_id":"a69cbe89-9485-476e-8905-2781595144de",
   * "upload_url":"/GrogshopUpload/dishes/20160811100249315jcyr.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"韭菜蚬肉 ","dishes_price":"19.60",
   * "dishes_id":"a69cbe89-9485-476e-8905-2781595144de",
   * "upload_url":"/GrogshopUpload/dishes/20160811100249315jcyr.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"百合蒸南瓜","dishes_price":"19.60",
   * "dishes_id":"a9c0b6ad-0a7c-43a8-876d-2bc7591852d3",
   * "upload_url":"/GrogshopUpload/dishes/20160811093219562bhzlg.png","list":null},
   * {"tagID":"8","type":null,"dishes_name":"百合蒸南瓜","dishes_price":"19.60",
   * "dishes_id":"a9c0b6ad-0a7c-43a8-876d-2bc7591852d3",
   * "upload_url":"/GrogshopUpload/dishes/20160811093219562bhzlg.png","list":null},
   * {"tagID":"1","type":null,"dishes_name":"农家锅巴","dishes_price":"22.40",
   * "dishes_id":"aabd10d3-bb85-4b41-9e0d-491f227e2ae8",
   * "upload_url":"/GrogshopUpload/dishes/20160811101430841njgb.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"农家锅巴","dishes_price":"22.40",
   * "dishes_id":"aabd10d3-bb85-4b41-9e0d-491f227e2ae8",
   * "upload_url":"/GrogshopUpload/dishes/20160811101430841njgb.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"农家藕饼","dishes_price":"23.40",
   * "dishes_id":"abc461a4-f927-4724-92a2-138951a2825a",
   * "upload_url":"/GrogshopUpload/dishes/20160811101546856njob.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"农家藕饼","dishes_price":"23.40",
   * "dishes_id":"abc461a4-f927-4724-92a2-138951a2825a",
   * "upload_url":"/GrogshopUpload/dishes/20160811101546856njob.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"昂刺鱼","dishes_price":"23.40",
   * "dishes_id":"abd0d355-b464-4882-a7e7-2a01a79407fa",
   * "upload_url":"/GrogshopUpload/dishes/20160811093119979hcy.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"昂刺鱼","dishes_price":"23.40",
   * "dishes_id":"abd0d355-b464-4882-a7e7-2a01a79407fa",
   * "upload_url":"/GrogshopUpload/dishes/20160811093119979hcy.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"汽锅肉汁香菇 ","dishes_price":"40.60",
   * "dishes_id":"ac221b50-1a22-4bfd-97fe-fa83d9c3ba02",
   * "upload_url":"/GrogshopUpload/dishes/20160811102636110qgrzxg.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"汽锅肉汁香菇 ","dishes_price":"40.60",
   * "dishes_id":"ac221b50-1a22-4bfd-97fe-fa83d9c3ba02",
   * "upload_url":"/GrogshopUpload/dishes/20160811102636110qgrzxg.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"豆浆","dishes_price":"11.00",
   * "dishes_id":"acd9e36d-6d49-40ba-a6c9-a04e4abd32fd",
   * "upload_url":"/GrogshopUpload/dishes/20160811094103638dj.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"豆浆","dishes_price":"11.00",
   * "dishes_id":"acd9e36d-6d49-40ba-a6c9-a04e4abd32fd",
   * "upload_url":"/GrogshopUpload/dishes/20160811094103638dj.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"槐树花炒鸡蛋","dishes_price":"22.00",
   * "dishes_id":"ad42a4ee-a90a-4988-9449-b88392feb6e6",
   * "upload_url":"/GrogshopUpload/dishes/20160811095723940hshcjd.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"槐树花炒鸡蛋","dishes_price":"22.00",
   * "dishes_id":"ad42a4ee-a90a-4988-9449-b88392feb6e6",
   * "upload_url":"/GrogshopUpload/dishes/20160811095723940hshcjd.jpg","list":null},
   * {"tagID":"2","type":null,"dishes_name":"干锅肉汁笋干 ","dishes_price":"17.40",
   * "dishes_id":"b14e2830-4fd8-405a-b73f-230b393d254b",
   * "upload_url":"/GrogshopUpload/dishes/20160811094357711ggszsg.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"干锅肉汁笋干 ","dishes_price":"17.40",
   * "dishes_id":"b14e2830-4fd8-405a-b73f-230b393d254b",
   * "upload_url":"/GrogshopUpload/dishes/20160811094357711ggszsg.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"香芋卷","dishes_price":"28.00",
   * "dishes_id":"b160508f-1758-4537-b1b9-7a439c9a1244",
   * "upload_url":"/GrogshopUpload/dishes/20160811112541544xyj.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"香芋卷","dishes_price":"28.00",
   * "dishes_id":"b160508f-1758-4537-b1b9-7a439c9a1244",
   * "upload_url":"/GrogshopUpload/dishes/20160811112541544xyj.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"萝卜皮","dishes_price":"12.00",
   * "dishes_id":"b4815bf1-1bd7-4cf6-950a-18a8fdba7386",
   * "upload_url":"/GrogshopUpload/dishes/20160811085050574lbp.jpg","list":null},{"tagID":"9",
   * "type":null,"dishes_name":"萝卜皮","dishes_price":"12.00",
   * "dishes_id":"b4815bf1-1bd7-4cf6-950a-18a8fdba7386",
   * "upload_url":"/GrogshopUpload/dishes/20160811085050574lbp.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"椒盐","dishes_price":"10.00",
   * "dishes_id":"b5780e12-d6ac-4772-8cf5-42d47c89259f",
   * "upload_url":"/GrogshopUpload/dishes/2016081109134882jy.jpg","list":null},{"tagID":"13",
   * "type":null,"dishes_name":"椒盐","dishes_price":"10.00",
   * "dishes_id":"b5780e12-d6ac-4772-8cf5-42d47c89259f",
   * "upload_url":"/GrogshopUpload/dishes/2016081109134882jy.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"茶树菇肚条","dishes_price":"30.40",
   * "dishes_id":"b59c2897-a643-49de-937b-cf6936adb3fb",
   * "upload_url":"/GrogshopUpload/dishes/20160811093516892csgdt.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"茶树菇肚条","dishes_price":"30.40",
   * "dishes_id":"b59c2897-a643-49de-937b-cf6936adb3fb",
   * "upload_url":"/GrogshopUpload/dishes/20160811093516892csgdt.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"有机花菜","dishes_price":"28.00",
   * "dishes_id":"b9f2580e-eebd-482e-ba31-e5187ecb7600",
   * "upload_url":"/GrogshopUpload/dishes/2016081115521916yjhc.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"有机花菜","dishes_price":"28.00",
   * "dishes_id":"b9f2580e-eebd-482e-ba31-e5187ecb7600",
   * "upload_url":"/GrogshopUpload/dishes/2016081115521916yjhc.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"猪头肉","dishes_price":"16.00",
   * "dishes_id":"befd93e5-f339-4ed5-a27e-ed4d056edb9b",
   * "upload_url":"/GrogshopUpload/dishes/20160811085239983ztr.jpg","list":null},{"tagID":"9",
   * "type":null,"dishes_name":"猪头肉","dishes_price":"16.00",
   * "dishes_id":"befd93e5-f339-4ed5-a27e-ed4d056edb9b",
   * "upload_url":"/GrogshopUpload/dishes/20160811085239983ztr.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"大煮干丝","dishes_price":"25.20",
   * "dishes_id":"c2244c0d-061a-4de5-9aa5-53549d66a361",
   * "upload_url":"/GrogshopUpload/dishes/20160811093748851dzgs.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"大煮干丝","dishes_price":"25.20",
   * "dishes_id":"c2244c0d-061a-4de5-9aa5-53549d66a361",
   * "upload_url":"/GrogshopUpload/dishes/20160811093748851dzgs.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"海鲜蒸蛋","dishes_price":"15.60",
   * "dishes_id":"c3478abc-f455-439d-aa39-500ceda89e10",
   * "upload_url":"/GrogshopUpload/dishes/20160811095039178hxzd.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"海鲜蒸蛋","dishes_price":"15.60",
   * "dishes_id":"c3478abc-f455-439d-aa39-500ceda89e10",
   * "upload_url":"/GrogshopUpload/dishes/20160811095039178hxzd.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"油炸冰淇淋","dishes_price":"18.00",
   * "dishes_id":"c7e0a639-5c1a-433b-b2ea-da03d7164190",
   * "upload_url":"/GrogshopUpload/dishes/20160811155058837yzbql.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"油炸冰淇淋","dishes_price":"18.00",
   * "dishes_id":"c7e0a639-5c1a-433b-b2ea-da03d7164190",
   * "upload_url":"/GrogshopUpload/dishes/20160811155058837yzbql.jpg","list":null},
   * {"tagID":"2","type":null,"dishes_name":"红豆烙 ","dishes_price":"17.40",
   * "dishes_id":"cb1640a6-8b84-48bc-8a75-2f806c671d61",
   * "upload_url":"/GrogshopUpload/dishes/20160811095137804hdl.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"红豆烙 ","dishes_price":"17.40",
   * "dishes_id":"cb1640a6-8b84-48bc-8a75-2f806c671d61",
   * "upload_url":"/GrogshopUpload/dishes/20160811095137804hdl.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"粽香排骨","dishes_price":"49.00",
   * "dishes_id":"cb3928f0-ff79-4698-99d3-aee5db8a1142",
   * "upload_url":"/GrogshopUpload/dishes/20160811155817650zxpg.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"粽香排骨","dishes_price":"49.00",
   * "dishes_id":"cb3928f0-ff79-4698-99d3-aee5db8a1142",
   * "upload_url":"/GrogshopUpload/dishes/20160811155817650zxpg.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"芥菜丸子","dishes_price":"19.00",
   * "dishes_id":"d09ac4c2-7164-48dc-b1d9-2c5073c777a9",
   * "upload_url":"/GrogshopUpload/dishes/20160811100108488jcwz.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"芥菜丸子","dishes_price":"19.00",
   * "dishes_id":"d09ac4c2-7164-48dc-b1d9-2c5073c777a9",
   * "upload_url":"/GrogshopUpload/dishes/20160811100108488jcwz.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"椒盐藕饼","dishes_price":"29.00",
   * "dishes_id":"d3a5b25f-5426-429a-a26b-7218bd78ddc8",
   * "upload_url":"/GrogshopUpload/dishes/20160811095836188jyob.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"椒盐藕饼","dishes_price":"29.00",
   * "dishes_id":"d3a5b25f-5426-429a-a26b-7218bd78ddc8",
   * "upload_url":"/GrogshopUpload/dishes/20160811095836188jyob.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"丝瓜毛豆","dishes_price":"22.00",
   * "dishes_id":"e202b8a0-bedd-4a47-a92b-ac49a76a112c",
   * "upload_url":"/GrogshopUpload/dishes/20160811110402568sgmd.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"丝瓜毛豆","dishes_price":"22.00",
   * "dishes_id":"e202b8a0-bedd-4a47-a92b-ac49a76a112c",
   * "upload_url":"/GrogshopUpload/dishes/20160811110402568sgmd.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"紫菜蛋汤","dishes_price":"12.00",
   * "dishes_id":"e2426c6e-0d00-42bf-a2e5-2ebc85000551",
   * "upload_url":"/GrogshopUpload/dishes/20160811092544240zcdt.jpg","list":null},
   * {"tagID":"13","type":null,"dishes_name":"紫菜蛋汤","dishes_price":"12.00",
   * "dishes_id":"e2426c6e-0d00-42bf-a2e5-2ebc85000551",
   * "upload_url":"/GrogshopUpload/dishes/20160811092544240zcdt.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"小打包盒","dishes_price":"1.00",
   * "dishes_id":"e470785c-3e39-4a31-8db7-a32d736afb87",
   * "upload_url":"/GrogshopUpload/dishes/20160811090628763xdbh.jpg","list":null},
   * {"tagID":"13","type":null,"dishes_name":"小打包盒","dishes_price":"1.00",
   * "dishes_id":"e470785c-3e39-4a31-8db7-a32d736afb87",
   * "upload_url":"/GrogshopUpload/dishes/20160811090628763xdbh.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"培根金针菇卷","dishes_price":"17.60",
   * "dishes_id":"e5871ef3-2129-4e86-a1af-ce07fdb7b5fb",
   * "upload_url":"/GrogshopUpload/dishes/20160811102529112pgjzgj.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"培根金针菇卷","dishes_price":"17.60",
   * "dishes_id":"e5871ef3-2129-4e86-a1af-ce07fdb7b5fb",
   * "upload_url":"/GrogshopUpload/dishes/20160811102529112pgjzgj.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"糖醋排骨","dishes_price":"48.00",
   * "dishes_id":"e5cbe262-6772-4aa3-ae8f-a626a5f3f90a",
   * "upload_url":"/GrogshopUpload/dishes/20160811111758471tcpg.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"糖醋排骨","dishes_price":"48.00",
   * "dishes_id":"e5cbe262-6772-4aa3-ae8f-a626a5f3f90a",
   * "upload_url":"/GrogshopUpload/dishes/20160811111758471tcpg.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"大打包盒 ","dishes_price":"3.00",
   * "dishes_id":"e7475828-e089-41c4-a294-bfd2f6f447a8",
   * "upload_url":"/GrogshopUpload/dishes/20160811090534913ddbh.jpg","list":null},
   * {"tagID":"13","type":null,"dishes_name":"大打包盒 ","dishes_price":"3.00",
   * "dishes_id":"e7475828-e089-41c4-a294-bfd2f6f447a8",
   * "upload_url":"/GrogshopUpload/dishes/20160811090534913ddbh.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"青菜面疙瘩","dishes_price":"18.00",
   * "dishes_id":"e8671d97-0bcf-44d4-8c57-20e357d4c1d3",
   * "upload_url":"/GrogshopUpload/dishes/20160811085518983qcmgd.jpg","list":null},
   * {"tagID":"10","type":null,"dishes_name":"青菜面疙瘩","dishes_price":"18.00",
   * "dishes_id":"e8671d97-0bcf-44d4-8c57-20e357d4c1d3",
   * "upload_url":"/GrogshopUpload/dishes/20160811085518983qcmgd.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"扬州炒饭 ","dishes_price":"18.00",
   * "dishes_id":"e8f5c5e0-f252-4556-89e5-a4961c4d032c",
   * "upload_url":"/GrogshopUpload/dishes/20160811085620930yzcf.jpg","list":null},
   * {"tagID":"10","type":null,"dishes_name":"扬州炒饭 ","dishes_price":"18.00",
   * "dishes_id":"e8f5c5e0-f252-4556-89e5-a4961c4d032c",
   * "upload_url":"/GrogshopUpload/dishes/20160811085620930yzcf.jpg","list":null},{"tagID":"1",
   * "type":null,"dishes_name":"阳春面","dishes_price":"12.00",
   * "dishes_id":"ecf606b7-1bf0-4c1b-b23b-308e34f6864f",
   * "upload_url":"/GrogshopUpload/dishes/20160811085712755ycm.jpg","list":null},{"tagID":"10",
   * "type":null,"dishes_name":"阳春面","dishes_price":"12.00",
   * "dishes_id":"ecf606b7-1bf0-4c1b-b23b-308e34f6864f",
   * "upload_url":"/GrogshopUpload/dishes/20160811085712755ycm.jpg","list":null},{"tagID":"3",
   * "type":null,"dishes_name":"腌菜花毛豆肉丝","dishes_price":"22.00",
   * "dishes_id":"f028bfe8-c4a3-452c-ba8d-861ef13c6cf6",
   * "upload_url":"/GrogshopUpload/dishes/20160811112919892ychmdrs.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"腌菜花毛豆肉丝","dishes_price":"22.00",
   * "dishes_id":"f028bfe8-c4a3-452c-ba8d-861ef13c6cf6",
   * "upload_url":"/GrogshopUpload/dishes/20160811112919892ychmdrs.jpg","list":null},
   * {"tagID":"3","type":null,"dishes_name":"珍菌豆瓣毛贝 ","dishes_price":"42.00",
   * "dishes_id":"f19c8c4d-f718-4977-a2f0-3ad0052b1338",
   * "upload_url":"/GrogshopUpload/dishes/20160811155553996zzdbmb.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"珍菌豆瓣毛贝 ","dishes_price":"42.00",
   * "dishes_id":"f19c8c4d-f718-4977-a2f0-3ad0052b1338",
   * "upload_url":"/GrogshopUpload/dishes/20160811155553996zzdbmb.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"干锅跳水蛙","dishes_price":"34.80",
   * "dishes_id":"fa471dcf-f2ba-4930-9de5-e1ee1a746205",
   * "upload_url":"/GrogshopUpload/dishes/20160811094628993ggtsw.jpg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"干锅跳水蛙","dishes_price":"34.80",
   * "dishes_id":"fa471dcf-f2ba-4930-9de5-e1ee1a746205",
   * "upload_url":"/GrogshopUpload/dishes/20160811094628993ggtsw.jpg","list":null},
   * {"tagID":"1","type":null,"dishes_name":"石锅花甲","dishes_price":"19.20",
   * "dishes_id":"fbea852d-2ede-47b9-9f52-296b03b16eff",
   * "upload_url":"/GrogshopUpload/dishes/20160811104815122sghj.jpeg","list":null},
   * {"tagID":"8","type":null,"dishes_name":"石锅花甲","dishes_price":"19.20",
   * "dishes_id":"fbea852d-2ede-47b9-9f52-296b03b16eff",
   * "upload_url":"/GrogshopUpload/dishes/20160811104815122sghj.jpeg","list":null},
   * {"tagID":"3","type":null,"dishes_name":"脆皮年糕","dishes_price":"19.80",
   * "dishes_id":"ffae5878-c6ed-404c-b13b-5c0b1f7644e5",
   * "upload_url":"/GrogshopUpload/dishes/20160811093630330cpng.jpg","list":null},{"tagID":"8",
   * "type":null,"dishes_name":"脆皮年糕","dishes_price":"19.80",
   * "dishes_id":"ffae5878-c6ed-404c-b13b-5c0b1f7644e5",
   * "upload_url":"/GrogshopUpload/dishes/20160811093630330cpng.jpg","list":null}]
   * value1 : null
   * errcode : null
   * errmsg : null
   * datas : null
   * pageNo : 0
   * pages : 0
   */

  private boolean success;
  private String message;
  private Object messageList;
  private Object messageList1;
  private Object messageList2;
  private Object messageList3;
  private Object messageList4;
  private Object messageList5;
  private Object messageList6;
  private Object messageList7;
  private Object messageList8;
  private int code;
  private Object value1;
  private Object errcode;
  private Object errmsg;
  private Object datas;
  private int pageNo;
  private int pages;
  /**
   * tagID : 1
   * type : null
   * dishes_name : 米饭每位一元
   * dishes_price : 1.00
   * dishes_id : e7d02f7f-5085-436a-95ce-83446cf53577
   * upload_url : /GrogshopUpload/dishes/20160811085410241mf.jpg
   * list : null
   */

  private List<ValueBean> value;

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getMessageList() {
    return messageList;
  }

  public void setMessageList(Object messageList) {
    this.messageList = messageList;
  }

  public Object getMessageList1() {
    return messageList1;
  }

  public void setMessageList1(Object messageList1) {
    this.messageList1 = messageList1;
  }

  public Object getMessageList2() {
    return messageList2;
  }

  public void setMessageList2(Object messageList2) {
    this.messageList2 = messageList2;
  }

  public Object getMessageList3() {
    return messageList3;
  }

  public void setMessageList3(Object messageList3) {
    this.messageList3 = messageList3;
  }

  public Object getMessageList4() {
    return messageList4;
  }

  public void setMessageList4(Object messageList4) {
    this.messageList4 = messageList4;
  }

  public Object getMessageList5() {
    return messageList5;
  }

  public void setMessageList5(Object messageList5) {
    this.messageList5 = messageList5;
  }

  public Object getMessageList6() {
    return messageList6;
  }

  public void setMessageList6(Object messageList6) {
    this.messageList6 = messageList6;
  }

  public Object getMessageList7() {
    return messageList7;
  }

  public void setMessageList7(Object messageList7) {
    this.messageList7 = messageList7;
  }

  public Object getMessageList8() {
    return messageList8;
  }

  public void setMessageList8(Object messageList8) {
    this.messageList8 = messageList8;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public Object getValue1() {
    return value1;
  }

  public void setValue1(Object value1) {
    this.value1 = value1;
  }

  public Object getErrcode() {
    return errcode;
  }

  public void setErrcode(Object errcode) {
    this.errcode = errcode;
  }

  public Object getErrmsg() {
    return errmsg;
  }

  public void setErrmsg(Object errmsg) {
    this.errmsg = errmsg;
  }

  public Object getDatas() {
    return datas;
  }

  public void setDatas(Object datas) {
    this.datas = datas;
  }

  public int getPageNo() {
    return pageNo;
  }

  public void setPageNo(int pageNo) {
    this.pageNo = pageNo;
  }

  public int getPages() {
    return pages;
  }

  public void setPages(int pages) {
    this.pages = pages;
  }

  public List<ValueBean> getValue() {
    return value;
  }

  public void setValue(List<ValueBean> value) {
    this.value = value;
  }

  public static class ValueBean {
    private String tagID;
    private Object type;
    private String dishes_name;
    private String dishes_price;
    private String dishes_id;
    private String upload_url;
    private Object list;

    public String getTagID() {
      return tagID;
    }

    public void setTagID(String tagID) {
      this.tagID = tagID;
    }

    public Object getType() {
      return type;
    }

    public void setType(Object type) {
      this.type = type;
    }

    public String getDishes_name() {
      return dishes_name;
    }

    public void setDishes_name(String dishes_name) {
      this.dishes_name = dishes_name;
    }

    public String getDishes_price() {
      return dishes_price;
    }

    public void setDishes_price(String dishes_price) {
      this.dishes_price = dishes_price;
    }

    public String getDishes_id() {
      return dishes_id;
    }

    public void setDishes_id(String dishes_id) {
      this.dishes_id = dishes_id;
    }

    public String getUpload_url() {
      return upload_url;
    }

    public void setUpload_url(String upload_url) {
      this.upload_url = upload_url;
    }

    public Object getList() {
      return list;
    }

    public void setList(Object list) {
      this.list = list;
    }
  }
}
