<template>
    <div id="app">
        <TopBar title="活动大咖"/>
        <router-view/>
    </div>
</template>

<script>
    import TopBar from './components/TopBar'
    import Scroll from './components/Scroll'

    export default {
        components: {
            Scroll,
            TopBar
        }
    }
</script>

<style lang="stylus">
    body {
        margin: 0;
        padding: 0;
        font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
    }

    #app {
        background #f8f8f8;
        min-height: 100vh
    }
</style>
