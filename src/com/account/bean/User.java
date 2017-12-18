package com.account.bean;
import java.io.Serializable;
public class User implements Serializable  {
        private Integer id;

        private String phone;

        private String username;

        private static final long serialVersionUID = 1L;


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone == null ? null : phone.trim();
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username == null ? null : username.trim();
        }

        public User(Integer id,String phone,String username){
            this.id = id;
            this.phone = phone == null ? null : phone.trim();
            this.username = username == null ? null : username.trim();
        }

        public User(String phone){
            this.phone = phone == null ? null : phone.trim();
        }

        public User(){}

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(" [");
            sb.append("Hash = ").append(hashCode());
            sb.append(", id=").append(id);
            sb.append(", phone=").append(phone);
            sb.append(", username=").append(username);
            sb.append(", serialVersionUID=").append(serialVersionUID);
            sb.append("]");
            return sb.toString();
        }
    }


