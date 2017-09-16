package com.lvqingyang.callcustomserver.bean;

import java.util.List;

/**
 * Author：LvQingYang
 * Date：2017/9/10
 * Email：biloba12345@gamil.com
 * Github：https://github.com/biloba123
 * Info：
 */
public class ServerOrder {

    /**
     * CallPlatform : {"Id":10010,"Name":"文思海辉智讯呼叫平台","Url":"call.pactera.com","Username":"Pactera6","Password":"97ca2e0b","AppID":null,"AppSecret":null,"Rank":1,"ApiUrl":"api.pactera.com","State":1,"OrderCount":1}
     * CustomServer : {"ServerID":100003,"Username":"hezepeng","Password":"123456","Phone":"18696162662","IdCard":"420922199610164632","Name":"何泽鹏","Email":"hezepeng96@163.com","RegisterTime":"2017-07-30T16:31:53.147","Balance":0,"Nickname":null,"Score":0,"WaittingBalance":"0         ","InBlackList":false}
     * Order : {"CallTasks":[{"CallResult":{"RunningID":1000000097,"ResultType":1,"Note":"无","AudioUrl":null},"RunningID":1000000097,"CallNo":"18696162662","Name":"何泽鹏","OrderID":1000035,"ServerID":100003,"IsExpress":false},{"CallResult":{"RunningID":1000000098,"ResultType":1,"Note":"无","AudioUrl":null},"RunningID":1000000098,"CallNo":"13260520443","Name":"廖庆涵","OrderID":1000035,"ServerID":100003,"IsExpress":false},{"CallResult":{"RunningID":1000000099,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000099,"CallNo":"15660521487","Name":"王子心","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000100,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000100,"CallNo":"18660514756","Name":"周沁仪","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000101,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000101,"CallNo":"13260517852","Name":"王悦","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000102,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000102,"CallNo":"18658689618","Name":"刘总","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000103,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000103,"CallNo":"13071258688","Name":"彭科长","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000104,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000104,"CallNo":"13554018566","Name":"周润发","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000105,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000105,"CallNo":"18898186888","Name":"王健林","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000106,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000106,"CallNo":"13018186866","Name":"王思聪","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000107,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000107,"CallNo":"15656891234","Name":"杨幂","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000108,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000108,"CallNo":"18956661818","Name":"郭富城","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000109,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000109,"CallNo":"18696881678","Name":"周星驰","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000110,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000110,"CallNo":"15628583666","Name":"陈女士","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000111,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000111,"CallNo":"13548755822","Name":"张小姐","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000112,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000112,"CallNo":"13056123567","Name":"李先生","OrderID":1000035,"ServerID":null,"IsExpress":false}],"Enterprise":{"EnterID":1000009,"EnterName":"文思海辉技术有限公司","CreditCode":null,"CredentialsUrl":null,"Balance":1499.04,"Password":"123456","Email":"admin@pactera.com","CorporateName":"何泽鹏","CorporateIdCard":"420922199610164632","CorporatePhone":"18696162662","RegisterTime":"2017-07-26T14:14:14","InBlackList":false},"OrderID":1000035,"EnterID":1000009,"CreateTime":"2017-08-07T19:19:13.18","Complete":false,"PrePay":3.84,"FinalPay":0,"EndTime":"2017-09-07T19:19:13.18","OrderType":3,"State":2,"RefuseReson":null,"UnitPrice":0.6,"PhoneCount":16,"CallListUrl":"/Upload/File/201709141089电话列表16个.txt","OrderName":"关于近期客服回访","CallContent":"询问客户对最近购买的商品是否满意","IsExpress":false,"SendSMS":false,"ReCallCount":0,"FinishCount":2,"RemainCount":0}
     * Id : 3
     * ServerID : 100003
     * OrderID : 1000035
     * CreateTime : 2017-09-10T15:37:46.123
     * Score : 0.0
     * FinishTime : null
     * ReCallCount : 0
     * Note : 无
     * CallCount : 2
     * Evaluate : 无
     * PlatformID : 10010
     * State : 0
     * FinishCount : 0
     */

    private CallPlatformBean CallPlatform;
    private CustomServerBean CustomServer;
    private OrderBean Order;
    private int Id;
    private int ServerID;
    private int OrderID;
    private String CreateTime;
    private double Score;
    private Object FinishTime;
    private int ReCallCount;
    private String Note;
    private int CallCount;
    private String Evaluate;
    private int PlatformID;
    private int State;
    private int FinishCount;

    public CallPlatformBean getCallPlatform() {
        return CallPlatform;
    }

    public void setCallPlatform(CallPlatformBean CallPlatform) {
        this.CallPlatform = CallPlatform;
    }

    public CustomServerBean getCustomServer() {
        return CustomServer;
    }

    public void setCustomServer(CustomServerBean CustomServer) {
        this.CustomServer = CustomServer;
    }

    public OrderBean getOrder() {
        return Order;
    }

    public void setOrder(OrderBean Order) {
        this.Order = Order;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getServerID() {
        return ServerID;
    }

    public void setServerID(int ServerID) {
        this.ServerID = ServerID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String CreateTime) {
        this.CreateTime = CreateTime;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double Score) {
        this.Score = Score;
    }

    public Object getFinishTime() {
        return FinishTime;
    }

    public void setFinishTime(Object FinishTime) {
        this.FinishTime = FinishTime;
    }

    public int getReCallCount() {
        return ReCallCount;
    }

    public void setReCallCount(int ReCallCount) {
        this.ReCallCount = ReCallCount;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public int getCallCount() {
        return CallCount;
    }

    public void setCallCount(int CallCount) {
        this.CallCount = CallCount;
    }

    public String getEvaluate() {
        return Evaluate;
    }

    public void setEvaluate(String Evaluate) {
        this.Evaluate = Evaluate;
    }

    public int getPlatformID() {
        return PlatformID;
    }

    public void setPlatformID(int PlatformID) {
        this.PlatformID = PlatformID;
    }

    public int getState() {
        return State;
    }

    public void setState(int State) {
        this.State = State;
    }

    public int getFinishCount() {
        return FinishCount;
    }

    public void setFinishCount(int FinishCount) {
        this.FinishCount = FinishCount;
    }

    public static class CallPlatformBean {
        /**
         * Id : 10010
         * Name : 文思海辉智讯呼叫平台
         * Url : call.pactera.com
         * Username : Pactera6
         * Password : 97ca2e0b
         * AppID : null
         * AppSecret : null
         * Rank : 1
         * ApiUrl : api.pactera.com
         * State : 1
         * OrderCount : 1
         */

        private int Id;
        private String Name;
        private String Url;
        private String Username;
        private String Password;
        private Object AppID;
        private Object AppSecret;
        private int Rank;
        private String ApiUrl;
        private int State;
        private int OrderCount;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String Url) {
            this.Url = Url;
        }

        public String getUsername() {
            return Username;
        }

        public void setUsername(String Username) {
            this.Username = Username;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String Password) {
            this.Password = Password;
        }

        public Object getAppID() {
            return AppID;
        }

        public void setAppID(Object AppID) {
            this.AppID = AppID;
        }

        public Object getAppSecret() {
            return AppSecret;
        }

        public void setAppSecret(Object AppSecret) {
            this.AppSecret = AppSecret;
        }

        public int getRank() {
            return Rank;
        }

        public void setRank(int Rank) {
            this.Rank = Rank;
        }

        public String getApiUrl() {
            return ApiUrl;
        }

        public void setApiUrl(String ApiUrl) {
            this.ApiUrl = ApiUrl;
        }

        public int getState() {
            return State;
        }

        public void setState(int State) {
            this.State = State;
        }

        public int getOrderCount() {
            return OrderCount;
        }

        public void setOrderCount(int OrderCount) {
            this.OrderCount = OrderCount;
        }
    }

    public static class CustomServerBean {
        /**
         * ServerID : 100003
         * Username : hezepeng
         * Password : 123456
         * Phone : 18696162662
         * IdCard : 420922199610164632
         * Name : 何泽鹏
         * Email : hezepeng96@163.com
         * RegisterTime : 2017-07-30T16:31:53.147
         * Balance : 0.0
         * Nickname : null
         * Score : 0.0
         * WaittingBalance : 0
         * InBlackList : false
         */

        private int ServerID;
        private String Username;
        private String Password;
        private String Phone;
        private String IdCard;
        private String Name;
        private String Email;
        private String RegisterTime;
        private double Balance;
        private Object Nickname;
        private double Score;
        private String WaittingBalance;
        private boolean InBlackList;

        public int getServerID() {
            return ServerID;
        }

        public void setServerID(int ServerID) {
            this.ServerID = ServerID;
        }

        public String getUsername() {
            return Username;
        }

        public void setUsername(String Username) {
            this.Username = Username;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String Password) {
            this.Password = Password;
        }

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String Phone) {
            this.Phone = Phone;
        }

        public String getIdCard() {
            return IdCard;
        }

        public void setIdCard(String IdCard) {
            this.IdCard = IdCard;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public String getRegisterTime() {
            return RegisterTime;
        }

        public void setRegisterTime(String RegisterTime) {
            this.RegisterTime = RegisterTime;
        }

        public double getBalance() {
            return Balance;
        }

        public void setBalance(double Balance) {
            this.Balance = Balance;
        }

        public Object getNickname() {
            return Nickname;
        }

        public void setNickname(Object Nickname) {
            this.Nickname = Nickname;
        }

        public double getScore() {
            return Score;
        }

        public void setScore(double Score) {
            this.Score = Score;
        }

        public String getWaittingBalance() {
            return WaittingBalance;
        }

        public void setWaittingBalance(String WaittingBalance) {
            this.WaittingBalance = WaittingBalance;
        }

        public boolean isInBlackList() {
            return InBlackList;
        }

        public void setInBlackList(boolean InBlackList) {
            this.InBlackList = InBlackList;
        }
    }

    public static class OrderBean {
        /**
         * CallTasks : [{"CallResult":{"RunningID":1000000097,"ResultType":1,"Note":"无","AudioUrl":null},"RunningID":1000000097,"CallNo":"18696162662","Name":"何泽鹏","OrderID":1000035,"ServerID":100003,"IsExpress":false},{"CallResult":{"RunningID":1000000098,"ResultType":1,"Note":"无","AudioUrl":null},"RunningID":1000000098,"CallNo":"13260520443","Name":"廖庆涵","OrderID":1000035,"ServerID":100003,"IsExpress":false},{"CallResult":{"RunningID":1000000099,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000099,"CallNo":"15660521487","Name":"王子心","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000100,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000100,"CallNo":"18660514756","Name":"周沁仪","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000101,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000101,"CallNo":"13260517852","Name":"王悦","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000102,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000102,"CallNo":"18658689618","Name":"刘总","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000103,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000103,"CallNo":"13071258688","Name":"彭科长","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000104,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000104,"CallNo":"13554018566","Name":"周润发","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000105,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000105,"CallNo":"18898186888","Name":"王健林","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000106,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000106,"CallNo":"13018186866","Name":"王思聪","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000107,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000107,"CallNo":"15656891234","Name":"杨幂","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000108,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000108,"CallNo":"18956661818","Name":"郭富城","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000109,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000109,"CallNo":"18696881678","Name":"周星驰","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000110,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000110,"CallNo":"15628583666","Name":"陈女士","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000111,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000111,"CallNo":"13548755822","Name":"张小姐","OrderID":1000035,"ServerID":null,"IsExpress":false},{"CallResult":{"RunningID":1000000112,"ResultType":0,"Note":"无","AudioUrl":null},"RunningID":1000000112,"CallNo":"13056123567","Name":"李先生","OrderID":1000035,"ServerID":null,"IsExpress":false}]
         * Enterprise : {"EnterID":1000009,"EnterName":"文思海辉技术有限公司","CreditCode":null,"CredentialsUrl":null,"Balance":1499.04,"Password":"123456","Email":"admin@pactera.com","CorporateName":"何泽鹏","CorporateIdCard":"420922199610164632","CorporatePhone":"18696162662","RegisterTime":"2017-07-26T14:14:14","InBlackList":false}
         * OrderID : 1000035
         * EnterID : 1000009
         * CreateTime : 2017-08-07T19:19:13.18
         * Complete : false
         * PrePay : 3.84
         * FinalPay : 0.0
         * EndTime : 2017-09-07T19:19:13.18
         * OrderType : 3
         * State : 2
         * RefuseReson : null
         * UnitPrice : 0.6
         * PhoneCount : 16
         * CallListUrl : /Upload/File/201709141089电话列表16个.txt
         * OrderName : 关于近期客服回访
         * CallContent : 询问客户对最近购买的商品是否满意
         * IsExpress : false
         * SendSMS : false
         * ReCallCount : 0
         * FinishCount : 2
         * RemainCount : 0
         */

        private EnterpriseBean Enterprise;
        private int OrderID;
        private int EnterID;
        private String CreateTime;
        private boolean Complete;
        private double PrePay;
        private double FinalPay;
        private String EndTime;
        private int OrderType;
        private int State;
        private Object RefuseReson;
        private double UnitPrice;
        private int PhoneCount;
        private String CallListUrl;
        private String OrderName;
        private String CallContent;
        private boolean IsExpress;
        private boolean SendSMS;
        private int ReCallCount;
        private int FinishCount;
        private int RemainCount;
        private List<CallTasksBean> CallTasks;

        public EnterpriseBean getEnterprise() {
            return Enterprise;
        }

        public void setEnterprise(EnterpriseBean Enterprise) {
            this.Enterprise = Enterprise;
        }

        public int getOrderID() {
            return OrderID;
        }

        public void setOrderID(int OrderID) {
            this.OrderID = OrderID;
        }

        public int getEnterID() {
            return EnterID;
        }

        public void setEnterID(int EnterID) {
            this.EnterID = EnterID;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public boolean isComplete() {
            return Complete;
        }

        public void setComplete(boolean Complete) {
            this.Complete = Complete;
        }

        public double getPrePay() {
            return PrePay;
        }

        public void setPrePay(double PrePay) {
            this.PrePay = PrePay;
        }

        public double getFinalPay() {
            return FinalPay;
        }

        public void setFinalPay(double FinalPay) {
            this.FinalPay = FinalPay;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public int getOrderType() {
            return OrderType;
        }

        public void setOrderType(int OrderType) {
            this.OrderType = OrderType;
        }

        public int getState() {
            return State;
        }

        public void setState(int State) {
            this.State = State;
        }

        public Object getRefuseReson() {
            return RefuseReson;
        }

        public void setRefuseReson(Object RefuseReson) {
            this.RefuseReson = RefuseReson;
        }

        public double getUnitPrice() {
            return UnitPrice;
        }

        public void setUnitPrice(double UnitPrice) {
            this.UnitPrice = UnitPrice;
        }

        public int getPhoneCount() {
            return PhoneCount;
        }

        public void setPhoneCount(int PhoneCount) {
            this.PhoneCount = PhoneCount;
        }

        public String getCallListUrl() {
            return CallListUrl;
        }

        public void setCallListUrl(String CallListUrl) {
            this.CallListUrl = CallListUrl;
        }

        public String getOrderName() {
            return OrderName;
        }

        public void setOrderName(String OrderName) {
            this.OrderName = OrderName;
        }

        public String getCallContent() {
            return CallContent;
        }

        public void setCallContent(String CallContent) {
            this.CallContent = CallContent;
        }

        public boolean isIsExpress() {
            return IsExpress;
        }

        public void setIsExpress(boolean IsExpress) {
            this.IsExpress = IsExpress;
        }

        public boolean isSendSMS() {
            return SendSMS;
        }

        public void setSendSMS(boolean SendSMS) {
            this.SendSMS = SendSMS;
        }

        public int getReCallCount() {
            return ReCallCount;
        }

        public void setReCallCount(int ReCallCount) {
            this.ReCallCount = ReCallCount;
        }

        public int getFinishCount() {
            return FinishCount;
        }

        public void setFinishCount(int FinishCount) {
            this.FinishCount = FinishCount;
        }

        public int getRemainCount() {
            return RemainCount;
        }

        public void setRemainCount(int RemainCount) {
            this.RemainCount = RemainCount;
        }

        public List<CallTasksBean> getCallTasks() {
            return CallTasks;
        }

        public void setCallTasks(List<CallTasksBean> CallTasks) {
            this.CallTasks = CallTasks;
        }

        public static class EnterpriseBean {
            /**
             * EnterID : 1000009
             * EnterName : 文思海辉技术有限公司
             * CreditCode : null
             * CredentialsUrl : null
             * Balance : 1499.04
             * Password : 123456
             * Email : admin@pactera.com
             * CorporateName : 何泽鹏
             * CorporateIdCard : 420922199610164632
             * CorporatePhone : 18696162662
             * RegisterTime : 2017-07-26T14:14:14
             * InBlackList : false
             */

            private int EnterID;
            private String EnterName;
            private Object CreditCode;
            private Object CredentialsUrl;
            private double Balance;
            private String Password;
            private String Email;
            private String CorporateName;
            private String CorporateIdCard;
            private String CorporatePhone;
            private String RegisterTime;
            private boolean InBlackList;

            public int getEnterID() {
                return EnterID;
            }

            public void setEnterID(int EnterID) {
                this.EnterID = EnterID;
            }

            public String getEnterName() {
                return EnterName;
            }

            public void setEnterName(String EnterName) {
                this.EnterName = EnterName;
            }

            public Object getCreditCode() {
                return CreditCode;
            }

            public void setCreditCode(Object CreditCode) {
                this.CreditCode = CreditCode;
            }

            public Object getCredentialsUrl() {
                return CredentialsUrl;
            }

            public void setCredentialsUrl(Object CredentialsUrl) {
                this.CredentialsUrl = CredentialsUrl;
            }

            public double getBalance() {
                return Balance;
            }

            public void setBalance(double Balance) {
                this.Balance = Balance;
            }

            public String getPassword() {
                return Password;
            }

            public void setPassword(String Password) {
                this.Password = Password;
            }

            public String getEmail() {
                return Email;
            }

            public void setEmail(String Email) {
                this.Email = Email;
            }

            public String getCorporateName() {
                return CorporateName;
            }

            public void setCorporateName(String CorporateName) {
                this.CorporateName = CorporateName;
            }

            public String getCorporateIdCard() {
                return CorporateIdCard;
            }

            public void setCorporateIdCard(String CorporateIdCard) {
                this.CorporateIdCard = CorporateIdCard;
            }

            public String getCorporatePhone() {
                return CorporatePhone;
            }

            public void setCorporatePhone(String CorporatePhone) {
                this.CorporatePhone = CorporatePhone;
            }

            public String getRegisterTime() {
                return RegisterTime;
            }

            public void setRegisterTime(String RegisterTime) {
                this.RegisterTime = RegisterTime;
            }

            public boolean isInBlackList() {
                return InBlackList;
            }

            public void setInBlackList(boolean InBlackList) {
                this.InBlackList = InBlackList;
            }
        }

        public static class CallTasksBean {
            /**
             * CallResult : {"RunningID":1000000097,"ResultType":1,"Note":"无","AudioUrl":null}
             * RunningID : 1000000097
             * CallNo : 18696162662
             * Name : 何泽鹏
             * OrderID : 1000035
             * ServerID : 100003
             * IsExpress : false
             */

            private CallResultBean CallResult;
            private int RunningID;
            private String CallNo;
            private String Name;
            private int OrderID;
            private int ServerID;
            private boolean IsExpress;

            public CallResultBean getCallResult() {
                return CallResult;
            }

            public void setCallResult(CallResultBean CallResult) {
                this.CallResult = CallResult;
            }

            public int getRunningID() {
                return RunningID;
            }

            public void setRunningID(int RunningID) {
                this.RunningID = RunningID;
            }

            public String getCallNo() {
                return CallNo;
            }

            public void setCallNo(String CallNo) {
                this.CallNo = CallNo;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public int getOrderID() {
                return OrderID;
            }

            public void setOrderID(int OrderID) {
                this.OrderID = OrderID;
            }

            public int getServerID() {
                return ServerID;
            }

            public void setServerID(int ServerID) {
                this.ServerID = ServerID;
            }

            public boolean isIsExpress() {
                return IsExpress;
            }

            public void setIsExpress(boolean IsExpress) {
                this.IsExpress = IsExpress;
            }

            public static class CallResultBean {
                /**
                 * RunningID : 1000000097
                 * ResultType : 1
                 * Note : 无
                 * AudioUrl : null
                 */

                private int RunningID;
                private int ResultType;
                private String Note;
                private Object AudioUrl;

                public int getRunningID() {
                    return RunningID;
                }

                public void setRunningID(int RunningID) {
                    this.RunningID = RunningID;
                }

                public int getResultType() {
                    return ResultType;
                }

                public void setResultType(int ResultType) {
                    this.ResultType = ResultType;
                }

                public String getNote() {
                    return Note;
                }

                public void setNote(String Note) {
                    this.Note = Note;
                }

                public Object getAudioUrl() {
                    return AudioUrl;
                }

                public void setAudioUrl(Object AudioUrl) {
                    this.AudioUrl = AudioUrl;
                }
            }
        }
    }
}
