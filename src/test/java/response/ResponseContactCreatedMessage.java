package response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseContactCreatedMessage {
    public String id;
    public String user_id;
    public String name;
    public String email;
    public String subject;
    public String message;
    public String status;
    public String created_at;
    public User user;
    public Object[] replies;

    // Inner class
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class User {
        public String id;
        public String first_name;
        public String last_name;
        public String email;
        public String dob;
        public String created_at;
        public Address address;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Address {
            public String street;
            public String city;
            public String state;
            public String country;
            public String postal_code;
        }
    }
}