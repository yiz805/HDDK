<template>
    <div id="top-bar">
        <div class="person">
            <slot></slot>
        </div>
        <div class="title">{{ title }}</div>
        <transition name="fade">
            <div class="back-arrow" v-show="showArrow" @click="arrowClick">
                <i class="el-icon-circle-close"></i>
            </div>
        </transition>
        <div class="clear"></div>
    </div>
</template>

<script>
    export default {
        name: "TopBar",
        props: {
            title: String,
            showArrow: {
                type: Boolean,
                default: false
            }
        },
        methods: {
            arrowClick() {
                this.$router.replace("/");
            }
        }
    }
</script>

<style scoped lang="stylus">
    @import "../assets/stylus/common.styl"

    #top-bar {
        height: 100px;
        background transparent;
        padding: 5px 20px;

        .back-arrow, .person {
            width: 110px;
            float right;
            height: 100px
            line-height 100px
        }

        .back-arrow {
            font-size 45px
            title-font()
        }

        .title {
            text-align center;
            width: calc(100vw - 260px);
            float right;
            line-height 100px
            font-size 35px;
            title-font()
        }
    }

    .fade-enter-active, .fade-leave-active {
        transition opacity .35s ease-in-out
    }

    .fade-enter, .fade-leave-to {
        opacity 0;
    }
</style>