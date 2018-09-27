<template>
    <div id="activity-list-item" ref="item">
        <div class="basic-info">
            <ActivityPreview :activity="activity"/>
        </div>

        <div class="progress-bar">
            <ActivityProgressBar :person-limit="activity.personLimit" :sign-up-number="activity.signUpNumber" />
        </div>
    </div>
</template>

<script>
    import ActivityPreview from './ActivityPreview'
    import ActivityProgressBar from '../ActivityProgressBar'

    export default {
        name: "ActivityListItem",
        props: {
            activity: Object
        },
        components: {
            ActivityProgressBar,
            ActivityPreview
        },
        methods: {
            showDetails() {

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
            /*margin-bottom: 20px*/
            background #fff
            border-radius 10px;
            box-shadow 0 18px 40px -20px #888;
            padding: 25px;
            position relative;
            z-index: 10;
            overflow hidden
        }

        .progress-bar {
            width: 90vw;
            background #fff;
            border-bottom-left-radius 10px;
            border-bottom-right-radius 10px;
            margin: 0 auto
            padding: 40px 20px 20px
            box-sizing border-box
            box-shadow 0 10px 20px -15px #555;
        }
    }
</style>