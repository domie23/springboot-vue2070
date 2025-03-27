const base = {
    get() {
        return {
            url : "http://localhost:8080/chengshilajifenleiguanlixitong/",
            name: "chengshilajifenleiguanlixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/chengshilajifenleiguanlixitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "城市垃圾分类管理系统"
        } 
    }
}
export default base
