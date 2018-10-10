<template>
    <div id="app">
        <TopBar :title="topBarTitle" :show-arrow="!isHome" color="#fff"/>
        <router-view/>
    </div>
</template>

<script>
    import TopBar from './components/TopBar'

    export default {
        components: {
            TopBar
        },
        data() {
            return {
                isHome: this.$route.name === "home"
            }
        },
        computed: {
            topBarTitle() {
                if (this.isHome) {
                    return "活动大咖";
                } else {
                    return "活动详情"
                }
            }
        },
        watch: {
            "$route": function(to) {
                if (to.name !== "home") {
                    this.isHome = false
                } else {
                    this.isHome = true
                }
            }
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
        background #fed351;
        min-height: 100vh
    }
</style>
