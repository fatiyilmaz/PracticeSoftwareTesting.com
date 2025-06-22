package request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRegisterResponse {
    private Integer registerId;
    private UserRegister register;


    public UserRegisterResponse() {
        // default constructor
    }
    public UserRegisterResponse(Integer registerId, UserRegister register) {
        this.registerId = registerId;
        this.register = register;
    }

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public UserRegister getRegister() {
        return register;
    }

    public void setRegister(UserRegister register) {
        this.register = register;
    }

    @Override
    public String toString() {
        return "UserRegisterResponse{" +
                "registerId=" + registerId +
                ", register=" + register +
                '}';
    }
}
