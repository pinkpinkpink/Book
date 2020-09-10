      
<template>
    <EpButton >text</EpButton>
    <EpButton type="default">default</EpButton>
    <EpButton type="primary">primary</EpButton>
    <EpButton type="success">success</EpButton>
    <br><br>
    <EpButton type="error">error</EpButton>
    <EpButton type="warning">Warning</EpButton>
    <EpButton type="gray">gray</EpButton>
    <br><br>
    <EpButton type="default">
        <a href="#" slot="a">a标签跳转</a>
    </EpButton>
</template>
<script>
    export default {
        
    }
</script>

- 删除

      
<template>
    <EpButton type="default" ico="back">default</EpButton>
    <EpButton type="default" ico="add">default</EpButton>
    <EpButton type="default" ico="import">default</EpButton>
    <EpButton type="default" ico="export">default</EpButton>
    <br><br>
    <EpButton type="error" ico="delete">error</EpButton>
    <EpButton type="warning" ico="batch-delete">Warning</EpButton>
    <EpButton type="gray" ico="batch-import">gray</EpButton>
</template>
<script>
    export default {
        
    }
</script>

  
  - 按钮大小
  
        
<template>
   <EpButton type="default">default</EpButton>
   <EpButton type="default" width="120px">default</EpButton>
   <EpButton type="default" height="36px">default</EpButton>
</template>
<script>
    export default {
    }
</script>

  
  
  - 标题
  
        
<template>
   <EpTitle type="center">替代文字替代文字</EpTitle>
</template>
<script>
    export default {
        
    }
</script>

  - 穿梭框
  
        
        <template>
          <EpButton type="default" @click="visible = true">显示机构选择框</EpButton>
        <EpSelectDept
          :default-select-data="selectDeptResult"
          :tree-data="treeDataList"
          :config="config"
          :visible="visible"
          :load-user="loadUser"
          @update:visible="isshow => { visible = isshow }"
          @on-save="saveSelectDeptData"
        ></EpSelectDept>
        </template>
        <script>
            export default {
              data(){
                return{
                  config: {
                    deptUrl: '', // 行政接口地址
                    userlistUrl: '', // 人员接口地址 oauth/getUserList
                    flagType: 'person', // dept(部门) person(人员)
                    singleFlag: false, // 是否单选,
                    seriesName: ['组织机构', '用户列表', '已选择项'], // 系列名称
                    name: '任务执行部门选择窗口' // 选择框名称
                  },
                  visible: false,
                  selectDeptResult: [],
                  treeDataList: [
                      {
                        label: '兰州市生态环境局',
                        type: 'dept',
                        id: '2ec4a630b7cc4739aeb5f419a88d2ae7',
                        parentId: '0',
                        children: [
                        {
                          label: '兰州市生态环境局城关分局',
                          id: 'dcd2ba47afe546dd9171bbf63750c6d4',
                          type: 'dept',
                          parentId: '2ec4a630b7cc4739aeb5f419a88d2ae7',
                          children: [],
                          expand: false
                        }
                      ],
                      expand: true
                    },
                    {
                      label: '甘肃省生态环境厅（甘肃省核安全局）',
                      id: '81bd5b8e31c54afab45b37c4b12a4211',
                      type: 'dept',
                      parentId: '0',
                      children: [
                        {
                          label: '财务审计处',
                          id: 'ff65aa315ad011eab2fa2c56dc000947',
                          type: 'dept',
                          parentId: '81bd5b8e31c54afab45b37c4b12a4211',
                          children: [],
                          expand: false
                        },
                        {
                          label: '法规与标准处',
                          id: 'ff65aa315ad011eab2fa2c56dc000086',
                          type: 'dept',
                          parentId: '81bd5b8e31c54afab45b37c4b12a4211',
                          children: [],
                          expand: false
                        }
                      ],
                      expand: true
                    }
                  ]
                }
              },
              methods:{
                saveSelectDeptData(result) {
                  this.selectDeptResult = result
                },
                loadUser(obj, callBack) {
                  callBack([
                  {
                    id: 'ff8080812171752b0121764457f40833',
                    label: 'Titans',
                    type: 'user',
                    code: '',
                    userMdn: '18919801022',
                    deptId: '808080805a1829d6015a3685f4dc60f7',
                    deptName: '规划发展处',
                    pid: '808080805a1829d6015a3685f4dc60f7'
                  },
                  {
                    id: 'ff8080812171752b0121764457f40834',
                    label: 'jason',
                    type: 'user',
                    code: '',
                    userMdn: '18919801022',
                    deptId: '808080805a1829d6015a3685f4dc60f7',
                    deptName: '规划发展处',
                    pid: '808080805a1829d6015a3685f4dc60f7'
                  }])
                }
              }
            }
        </script>
        
  
  
  # 导航
  
        
<template>
  <EpLeftNav :defaultactivenav="defaultactivenav" :leftnavdata="leftnavdata" @onLeftNavClick="onLeftNavClick"></EpLeftNav>
</template>
<script>
  export default {
    data() {
      return {
        code: Code,
        ifrouteractive: true,
        defaultactivenav: [0, 1], // [0, 0, 1]
        leftnavdata: [
        {
          id: 'mis',
          name: 'mis',
          fontCode: 'leftfontwurantianqiyujing',
          routerName: '',
          children: [
          {
            id: '列表详情',
            name: '列表详情',
            fontCode: '',
            routerName: '',
            children: [
            {
              id: '列表',
              name: '列表',
              fontCode: '',
              routerName: '',
              children: []
            },
            {
              id: '详情',
              name: '详情',
              fontCode: '',
              routerName: '',
              children: []
            }]
          },
          {
            id: '统计分析',
            name: '统计分析',
            fontCode: '',
            routerName: '',
            children: [
            {
              id: 'chart图表',
              name: 'chart图表',
              fontCode: '',
              routerName: '',
              children: []
            }]
          }]
        },
        {
          id: '特殊页面',
          name: '特殊页面',
          fontCode: 'leftfontwurantianqiyujing',
          routerName: '',
          children: [
          {
            id: '流程',
            name: '流程',
            fontCode: '',
            routerName: '',
            children: [
            {
              id: '办事流程',
              name: '办事流程',
              fontCode: '',
              routerName: ''
            }]
          }]
        }]
      }
    },
    methods: {
      onLeftNavClick(obj, isCurnav) {
        if (isCurnav) {
          // router-view 刷新 v-if="ifrouteractive"
          // this.ifrouteractive = false
          // this.$nextTick(t => {
          //   this.ifrouteractive = true
          // })
        } else {
          // this.ifrouteractive = true
          this.curSelectLeftNavObj = obj
          this.$router.push({
            name: obj.routerName,
            params: { crumbsdata: obj.crumbsdata }
          })
          // this.$store.commit('setCrumbsData', obj.crumbsdata)
        }
      }
    }
  }
</script>

  - tab切换
  
        
<template>
   <EpTab  @onTabClick="onTabClick" :tablist="tablist"></EpTab>
   <ul class="tabUl">
      <li v-show="curindex === 0">真好吃</li>
      <li v-show="curindex === 1">太辣了</li>
    </ul>
</template>
<script>
export default {
  data() {
    return {
      curindex: 0,
      tablist: [{ labelName: '麻辣烫' }, { labelName: '手擀粉' }]
    }
  },
  methods: {
    onTabClick(index) {
      this.curindex = index
    }
  }
}
</script>

  
  
  - 面包屑
  
        
<template>
    <EpCrumbs :crumbsdata="crumbsdata"></EpCrumbs>
</template>
<script>
    export default {
     crumbsdata: [
        {name: '基础'},
        {name: '标题'},
        {name: '按钮'}
      ]
    }
</script>

  - 返回头部
  
        
<template>
     <EpHomeHeader :name="name"></EpHomeHeader>
</template>
<script>
    export default {
       data(){
           return{
               name: '替代文字替代文字'   
           }
       }
    }
</script>

  - 菜单头部
  
        
<template>
   <EpHomeHeader 
        :defultselectinidex="defaultselectmenuindex" 
        @navclick="onNavClick" 
        :menulist="menulist" 
        :headnavdefaultlength="headnavdefaultlength"
        :name="name">
   </EpHomeHeader>
</template>
<script>
    export default {
        data(){
            return{
                headnavdefaultlength: 8,
                defaultselectmenuindex: 1,
                menulist: [{
                'name': '菜单一',
                'fontCode': 'headfontyizhangtu',
                'url': '',
                'routerName': 'radiationMap'
            }, {
                'name': '菜单二',
                'fontCode': 'headfontyun',
                'url': '',
                'routerName': 'componentAPI'
            }, {
                'name': '菜单三',
                'fontCode': 'headfontluanduiluanfang',
                'url': '',
                'routerName': 'approve'
            }, {
                'name': '菜单四',
                'fontCode': 'headfontmubiaokaohe',
                'url': '',
                'routerName': 'radSource'
            }, {
                'name': '菜单五',
                'fontCode': 'headfontmei',
                'url': '',
                'routerName': 'device'
            }]
            }
        },
        methods:{
            onNavClick(obj) {
            if (obj.isactive) {
                this.ifrouteractive = false
                this.$nextTick(t => {
                this.ifrouteractive = true
                })
            } else {
                this.ifrouteractive = true
                this.$router.push({
                name: obj.routerName,
                params: {
                    data: [],
                    value: 2
                }
                })
            }}
        }
    }
</script>

  
- 搜索框

      
<template>
 <EpSearchBox
    :has-highsearch="false"
    @onSearchBtnClick="onSearchBtnClick"
    @onHighSearchBtnClick="onSearchBtnClick"
    @onResetBtnClick="onResetBtnClick"
  >
    <!-- 默认基础搜索条件 -->
    <div slot="default">
      <div class="fn-inline inputel">
        <label class="fn-inline">label</label>
        <div class="fn-inline selectinput">
          <Input v-model="serchParams.labelValue1" placeholder="请输入" />
        </div>
      </div>
      <div class="fn-inline inputel">
        <label class="fn-inline">label</label>
        <div class="fn-inline selectinput">
          <Input v-model="serchParams.labelValue2" placeholder="请输入" />
        </div>
      </div>
      <div class="fn-inline inputel">
        <label class="fn-inline">label</label>
        <div class="fn-inline selectinput">
          <Input v-model="serchParams.labelValue3" placeholder="请输入" />
        </div>
      </div>
    </div>
    <!-- 高级搜索条件 -->
    <div slot="high">
      <div class="fn-inline inputel">
        <label class="fn-inline">label</label>
        <div class="fn-inline selectinput">
          <Input v-model="serchParams.labelValue4" placeholder="请输入" />
        </div>
      </div>
      <div class="fn-inline inputel">
        <label class="fn-inline">label</label>
        <div class="fn-inline selectinput">
          <Input v-model="serchParams.labelValue5" placeholder="请输入" />
        </div>
      </div>
      <div class="fn-inline inputel">
        <label class="fn-inline">label</label>
        <div class="fn-inline selectinput">
          <Input v-model="serchParams.labelValue6" placeholder="请输入" />
        </div>
      </div>
    </div>
  </EpSearchBox>
</template>
<script>
    export default {
     data(){
       return{
        titleName: '搜索框'
        serchParams: {
          labelValue1: '',
          labelValue2: '',
          labelValue3: '',
          labelValue4: '',
          labelValue5: '',
          labelValue6: ''
        }
        }
      },
      methods: {
        onSearchBtnClick() {
          console.log(this.serchParams)
        },
        onResetBtnClick() {
          let serchParams = {
            labelValue1: '',
            labelValue2: '',
            labelValue3: '',
            labelValue4: '',
            labelValue5: '',
            labelValue6: ''
          }
          Object.assign(this.serchParams, serchParams)
        }
      }
    }
</script>

  
# 其他

## 数字滚动

- 大屏数字滚动

      
<template>
   <EpNumScroll 
    :num='20200114' 
    :len='9' 
    :speed="1" 
    :type="1">
   </EpNumScroll>
</template>
<script>
export default {
  data() {
    return {
    }
  }
}
</script>

  
  
      
<template>
   <EpNumScroll 
    :num='20200114' 
    :len='9' 
    :speed="arr" 
    :type="1">
   </EpNumScroll>
</template>
<script>
export default {
  data() {
    return {
      arr:[50,500]
    }
  }
}
</script>


- 文本数字滚动

      
<template>
   <EpNumScroll  
    :startVal='0' 
    :endVal='1000' 
    :speed='5' 
    :decimals='1' 
    :type="2" 
    :isReverse='false'>
   </EpNumScroll>
</template>
<script>
export default {
  data() {
    return {
    }
  }
}
</script>

- 上传图片

      
<template>
    <div class="kmc-epword-container">
        <EpPicUploader
        ref="uploader"
        :target="target"
        :get-img-api="getImgApi"
        :del-url-path="delUrlPath"
        :file-status-text="statusText"
        :attrs-img="attrsImg"
        :max-size="maxSize"
        :up-list-default="upListDefault"
        :biz-id="bizId"
        @file-complete="fileComplete"
        @file-success="fileSuccess"
        @complete="complete"
        @remove-before="removeBefore"
        @file-removed-complete="fileRemovedComplete"
        @file-removed-success="fileRemovedSuccess"
        @file-removed-error="fileRemovedError"
        ></EpPicUploader>
        <div class="kmc-btn-get">
            <EpButton type="primary" width="200px" height="40px" @click="getData">获取当前已上传文件数据</EpButton>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      target: fileUrl + 'core-api/eemp/v1/eempFastdfs/upload', // 上传文件请求接口地址
      getImgApi: fileUrl + 'core-api/eemp/v1/eempFastdfs/getPic?filePath=', // 获取图片资源请求接口地址
      delUrlPath: fileUrl + '/core-api/eemp/v1/eempFastdfs/delDoc', // 删除文件请求接口地址
      maxSize: 1024, // 上传图片最大尺寸 默认不限 单位kb
      attrsImg: ['image/jpeg', 'image/png'], // 上传图片类型 默认为 ['image/gif', 'image/jpg', 'image/jpeg', 'image/png', 'image/bmp', 'image/webp']
      upListDefault: [], // 已上传文件列表
      bizId: 'test',
      statusText: {
        success: '成功了',
        error: '出错了',
        uploading: '上传中',
        waiting: '等待中'
      }
    }
  },
  methods: {
    // 获取当前业务已上传文档列表数据
    getUpLoadedList() {
      // get('/core-api/eemp/v1/uploadDoc/list', {}, 'http://10.18.32.146:8006').then(res => {
      //   console.log(res)
      // })
      this.upListDefault = [
        {
          fileOrgName: 'test',
          fileSaveName: 'test.png',
          fileType: 'png',
          fileSize: '22354',
          filePath: 'group1/M00/00/04/ChJkSV6lUwmAZMXEAA3lQv4KWzk239.png',
          createTime: new Date()
        }
      ]
    },
    // 整个上传完毕
    complete() {
      console.log('整个上传完毕')
    },
    // 一个文件上传完成
    fileComplete(file) {
      console.log('一个文件上传完成', file)
    },
    // 文件上传成功
    fileSuccess(rootFile, file, message, chunk) {
      console.log(rootFile, file, message, chunk)
    },
    // 点击删除before
    removeBefore(file, callBack, index) {
      console.log('文件删除之前操作 ---，开始回调删除')
    },
    // 文件已在远程删除成功
    fileRemovedSuccess(file) {
      console.log('文件已在远程删除成功', file)
    },
    // 文件已在远程删除失败
    fileRemovedError(file) {
      console.log('文件已在远程删除失败', file)
    },
    // 文件已在本地列表删除后
    fileRemovedComplete(file) {
      console.log('文件已在本地列表删除后', file)
    },
    // 提交时本地当前已上传文件
    getData() {
      let arr = this.$refs.uploader.getCurUploadedData() // 提交的数据
      console.log(arr)
    }
  },
  mounted() {
    this.getUpLoadedList()
    this.$nextTick(() => {
      window.uploader = this.$refs.uploader.uploader
    })
  }
}
</script>
<style>
.kmc-epword-container{
    height: 230px;
}
</style>

  - 上传
        
<template>
    <div class="kmc-epword-container">
        <EpUploader
          ref="uploader"
          :target="target"
          :file-status-text="statusText"
          :max-size="maxSize"
          :down-url="downUrl"
          :del-url="delUrl"
          :up-list-default="upListDefault"
          :biz-id="bizId"
          @file-complete="fileComplete"
          @file-success="fileSuccess"
          @complete="complete"
          @remove-before="removeBefore"
          @file-removed-success="fileRemovedSuccess"
          @file-removederror="fileRemovedError"
          @file-removedcomplete="fileRemovedComplete"
        ></EpUploader>
        <div class="kmc-btn-get">
            <EpButton type="primary" width="200px" height="40px" @click="getData">获取当前已上传文件数据</EpButton>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      target: fileUrl + 'core-api/eemp/v1/eempFastdfs/upload', // 上传文件请求接口地址
      downUrl: fileUrl + 'core-api/eemp/v1/eempFastdfs/downLoad', // 下载文件请求接口地址
      delUrl: fileUrl + 'core-api/eemp/v1/eempFastdfs/delDoc', // 删除文件地址
      maxSize: 1024, // 上传文件最大限制 默认不限
      upListDefault: [], // 已上传文件列表
      bizId: 'test',
      statusText: {
        success: '成功了',
        error: '出错了',
        uploading: '上传中',
        paused: '暂停中',
        waiting: '等待中'
      }
    }
  },
  methods: {
    // 获取当前业务已上传文档列表数据
    getUpLoadedList() {
      // get('/core-api/eemp/v1/uploadDoc/list', {}, 'http://10.18.32.146:8006').then(res => {
      //   // this.upListDefault = res.data.items
      // })
      this.upListDefault = [
        {
          fileOrgName: 'test',
          fileSaveName: 'test.png',
          fileType: 'png',
          fileSize: '22354',
          bisSystemId: 'test',
          filePath: 'group1/M00/00/09/ChJkt16i3JaAd06UAA3lQv4KWzk183.png',
          createTime: new Date()
        }
      ]
    },
    complete(args) {
      console.log('complete', args)
    },
    fileComplete(args) {
      console.log('file complete', args)
    },
    fileSuccess(rootFile, file, message, chunk) {
    },
    // 点击删除before
    removeBefore(file) {
      console.log('文件删除之前操作 ---，开始回调删除', file)
    },
    // 文件远程删除成功
    fileRemovedSuccess(file) {
      console.log('文件远程删除成功', file)
    },
    // 文件远程删除失败
    fileRemovedError(file) {
      console.log('文件远程删除失败', file)
    },
    // 文件已在本地列表删除后
    fileRemovedComplete(file) {
      console.log('文件已在本地列表删除后', file)
    },
    // 提交时本地当前已上传文件
    getData() {
      let arr = this.$refs.uploader.getCurUploadedData() // 提交的数据
      console.log(arr)
    }
  },
  mounted() {
    this.getUpLoadedList()
    this.$nextTick(() => {
      window.uploader = this.$refs.uploader.uploader
    })
  }
}
</script>
<style>
.kmc-epword-container{
    height: 230px;
}
</style>

  - 导入
  
        
<template>
  <div>
    <EpImportFile
      :template-down-params="templateDownParams"
      :template-down-url="templateDownUrl"
      :upload-url="uploadUrl"
    ></EpImportFile>
  </div>
</template>

<script>
export default {
  data() {
    return {
      templateDownParams: 'CSFL', // 下载模板必须传参数
      templateDownUrl: 'http://10.18.32.251:8013/biz-api/eemp/pfmg/v1/parameterConfig/downLoadFormwork', // 下载模板url
      uploadUrl: 'http://10.18.32.251:8013/eemp/pfmg/v1/ZT_TYCSGL_ZDPZ/impoetDate'// 导入文件baseurl
    }
  }
}
</script>
<style lang="scss" scoped>
</style>

    
