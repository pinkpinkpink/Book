<img
                v-if="index === 0"
                :src="getImgApi + item.imgPath + '&' + 'bizId=' + item.bizId"
              >
              
              
<!-- <img
                v-if="index === 0"
                src="http://10.18.100.234:9006/core-api/eemp/v1/eempFastdfs/getPic?filePath=group1/M00/00/8C/ChJk6l9Y5GiAAwS_AACZurj8Ff4183.png&bizId=4"
                alt=""
              > -->              

:src="item.imgPath"
