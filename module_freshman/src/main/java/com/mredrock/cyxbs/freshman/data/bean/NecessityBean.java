package com.mredrock.cyxbs.freshman.data.bean;

import java.util.List;

/**
 * Created by Tree on 2019/8/2 16:01
 */
public class NecessityBean {

    /**
     * code : 200
     * info : ok
     * text : [{"title":"报道必备","data":[{"name":"录取通知书","detail":"...."},{"name":"高考准考证","detail":"...."}]},{"title":"军训必备","data":[{"name":"花露水","detail":"...."},{"name":"防暑药","detail":"...."}]},{"title":"*以下为非必需","data":[{"name":"*学籍档案","detail":"...."},{"name":"*本人户口本内页","detail":"...."}]}]
     */

    private int code;
    private String info;
    private List<TextBean> text;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<TextBean> getText() {
        return text;
    }

    public void setText(List<TextBean> text) {
        this.text = text;
    }

    public static class TextBean {
        /**
         * title : 报道必备
         * data : [{"name":"录取通知书","detail":"...."},{"name":"高考准考证","detail":"...."}]
         */

        private String title;
        private List<DataBean> data;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * name : 录取通知书
             * detail : ....
             */

            private String name;
            private String detail;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }
        }
    }
}
