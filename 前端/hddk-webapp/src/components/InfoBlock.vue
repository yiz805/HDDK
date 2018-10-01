<template>
    <div class="block">
        <div class="icon">
            <slot></slot>
        </div>
        <div class="text">{{ content }}</div>
    </div>
</template>

<script>
    export default {
        name: "InfoBlock",
        props: {
            content: String | Number
        }
    }
</script>

<style scoped lang="stylus">
    .block {
        width: 100%
        margin-bottom: 10px
        overflow auto

        .icon {
            width: 80px
            height: 60px
            background #ff9800
            line-height 60px
            text-align center
            display inline-block
            float left
            border-top-left-radius 30px
            border-bottom-left-radius 30px

            svg {
                color #fff
            }
        }

        .text {
            display inline-block
            width: calc(100% - 80px)
            text-align center
            float left
            height 60px
            color #000000bf
            line-height 60px
            background #ffbe0059
            border-top-right-radius 30px
            border-bottom-right-radius 30px
        }
    }
</style>