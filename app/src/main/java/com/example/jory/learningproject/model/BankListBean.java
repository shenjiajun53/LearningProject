package com.example.jory.learningproject.model;

import java.util.List;

/**
 * Created by shenjj on 2016/11/23.
 */

public class BankListBean {

    /**
     * result : [{"bankId":9,"bankName":"中国建设银行","defaultStatus":false},{"bankId":4,"bankName":"中国农业银行","defaultStatus":false},{"bankId":8,"bankName":"中国工商银行","defaultStatus":false},{"bankId":10,"bankName":"招商银行","defaultStatus":false},{"bankId":1,"bankName":"中国银行","defaultStatus":true},{"bankId":7,"bankName":"平安银行","defaultStatus":false},{"bankId":14,"bankName":"宁波银行","defaultStatus":false},{"bankId":3,"bankName":"中信银行","defaultStatus":false},{"bankId":5,"bankName":"光大银行","defaultStatus":false},{"bankId":6,"bankName":"兴业银行","defaultStatus":false}]
     * error : null
     */

    private Object error;
    private List<ResultBean> result;

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BankListBean{" +
                "error=" + error +
                ", result=" + result +
                '}';
    }

    public static class ResultBean {
        /**
         * bankId : 9
         * bankName : 中国建设银行
         * defaultStatus : false
         */

        private int bankId;
        private String bankName;
        private boolean defaultStatus;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "bankId=" + bankId +
                    ", bankName='" + bankName + '\'' +
                    ", defaultStatus=" + defaultStatus +
                    '}';
        }

        public int getBankId() {
            return bankId;
        }

        public void setBankId(int bankId) {
            this.bankId = bankId;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public boolean isDefaultStatus() {
            return defaultStatus;
        }

        public void setDefaultStatus(boolean defaultStatus) {
            this.defaultStatus = defaultStatus;
        }
    }
}
