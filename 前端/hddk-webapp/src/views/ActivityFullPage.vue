<template>
    <div id="activity-full-page">
        <Scroll class="wrapper">
            <div class="content">
                <div class="preview">
                    <ActivityPreview :activity="activity"/>
                </div>
            </div>
        </Scroll>
    </div>
</template>

<script>
    import ActivityPreview from '../components/ActivityListItem/ActivityPreview'

    export default {
        name: "ActivityFullPage",
        components: {
            ActivityPreview
        },
        props: ['id'],
        data() {
            return {
                activity: {}
            }
        },
        methods: {
            getActivity() {
                this.$http.get('/api/activity/' + this.id).then((res) => {
                    this.activity = res.data.activity
                })
            }
        },
        mounted() {
            this.getActivity();
        }
    }
</script>

<style scoped lang="stylus">
    #activity-full-page {

        .content {
            background #fff
            width: 100vw
            border-top-right-radius 15px
            border-top-left-radius 15px
            overflow hidden
            position relative
            height: calc(100vh - 110px)
            margin-top calc(-100vh + 110px)
        }
    }
</style>