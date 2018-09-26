<template>
    <div id="activity-list-item" ref="item">
        <ActivityPreview :activity="activity" @click.native="showDetails"/>
    </div>
</template>

<script>
    import ActivityDetails from './ActivityDetails'
    import ActivityPreview from './ActivityPreview'

    export default {
        name: "ActivityListItem",
        props: {
            activity: Object
        },
        components: {
            ActivityDetails,
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
        background #fff
        width: 94vw;
        margin 0 auto;
        height: auto
        border-radius 10px;
        box-shadow 0 10px 20px -15px #000;
        margin-bottom: 40px;
        padding: 25px;
        box-sizing border-box
        position relative
        transition box-shadow .1s ease-in-out, all .5s ease-in-out;
    }
</style>