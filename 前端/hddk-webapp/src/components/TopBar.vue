<template>
    <div id="top-bar">
        <div class="back-arrow"></div>
        <div class="title">{{ title }}</div>
        <div class="person">
            <slot></slot>
        </div>
        <div class="clear"></div>
    </div>
</template>

<script>
    export default {
        name: "TopBar",
        props: {
            _route: Object,
            title: String
        }
    }
</script>

<style scoped lang="stylus">
    @import "../assets/stylus/common.styl"

    #top-bar {
        height: 100px;
        background #f8f8f8;
        padding: 5px 20px;

        .back-arrow, .person {
            width: 110px;
            float left;
            height: 100px
            line-height 100px
        }

        .title {
            text-align center;
            width: calc(100vw - 260px);
            float left;
            line-height 100px
            font-size 35px;
            title-font()
        }
    }
</style>