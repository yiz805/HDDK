<template>
    <div id="activity-list-item">
        <div class="basic-info" @click="itemClick">
            <ActivityPreview :activity="activity"/>
        </div>

        <div class="pre-btn" @click="preBtnClick">
            <transition name="fade">
                <font-icon icon="angle-double-down" v-if="!showPre"/>
                <font-icon icon="times" v-else/>
            </transition>
        </div>

        <div class="progress-bar" ref="itemProgressBar">
            <ActivityProgressBar :person-limit="activity.personLimit" :sign-up-number="activity.signUpNumber" />
        </div>
    </div>
</template>

<script>
    import ActivityPreview from './ActivityPreview'
    import ActivityProgressBar from '../ProgressBar'

    export default {
        name: "ActivityListItem",
        props: {
            activity: Object
        },
        data() {
            return {
                showPre: false
            }
        },
        components: {
            ActivityProgressBar,
            ActivityPreview
        },
        methods: {
            itemClick() {
                this.$emit('item-click');
            },
            preBtnClick() {
                this.showPre = !this.showPre
                if (this.showPre) {
                    this.$refs.itemProgressBar.style.marginTop = '0px';
                } else {
                    this.$refs.itemProgressBar.style.marginTop = '-15.333vw';
                }
            }
        }
    }
</script>

<style scoped lang="stylus">
    #activity-list-item {
        width: 94vw;
        margin 0 auto;
        height: auto
        margin-bottom: 40px;
        box-sizing border-box
        position relative

        .basic-info {
            background #fff
            border-radius 10px;
            box-shadow 0 18px 40px -20px #888;
            position relative;
            z-index: 10;
            overflow hidden
        }

        .pre-btn {
            display inline-block
            width 50px
            height 50px
            border-radius 50%
            line-height 50px
            text-align center
            font-size 32px
            position absolute
            right 50%
            transform translateX(50%)
            top 155px
            z-index 10
            background #fff
            box-shadow 0 5px 15px -5px #777
            color #555
        }

        .progress-bar {
            width: 90vw;
            background #fff;
            border-bottom-left-radius 10px;
            border-bottom-right-radius 10px;
            margin: 0 auto
            padding: 40px 20px 40px
            box-sizing border-box
            box-shadow 0 10px 20px -15px #555;
            margin-top -115px
            transition margin-top .3s ease
        }
    }

    .fade-enter-active, .fade-leave-active {
        transition opacity .35s ease-in-out
    }

    .fade-enter, .fade-leave-to {
        opacity 0
    }
</style>