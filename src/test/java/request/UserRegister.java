package request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRegister {
        private String first_name;
        private String last_name;
        private AddressUserRegister address;
        private String phone;
        private String dob;
        private String password;
        private String email;


        public UserRegister(String first_name, String last_name, AddressUserRegister address, String phone, String dob, String password, String email) {
                this.first_name = first_name;
                this.last_name = last_name;
                this.address = address;
                this.phone = phone;
                this.dob = dob;
                this.password = password;
                this.email = email;
        }

        public String getFirst_name() {
                return first_name;
        }

        public void setFirst_name(String first_name) {
                this.first_name = first_name;
        }

        public String getLast_name() {
                return last_name;
        }

        public void setLast_name(String last_name) {
                this.last_name = last_name;
        }

        public AddressUserRegister getAddress() {
                return address;
        }

        public void setAddress(AddressUserRegister address) {
                this.address = address;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getDob() {
                return dob;
        }

        public void setDob(String dob) {
                this.dob = dob;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        @Override
        public String toString() {
                return "UserRegister{" +
                        "first_name='" + first_name + '\'' +
                        ", last_name='" + last_name + '\'' +
                        ", address=" + address +
                        ", phone='" + phone + '\'' +
                        ", dob='" + dob + '\'' +
                        ", password='" + password + '\'' +
                        ", email='" + email + '\'' +
                        '}';
        }
}
