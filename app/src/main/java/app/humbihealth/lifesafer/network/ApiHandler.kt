package com.ewnbd.lifvesafer.network


import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ApiHandler {

   /* //Get Subscription
    @GET(Endpoints.API_GET_SUBSCRIPTION)
    fun getSubscription(): Call<GenericDataResponse<SubscriptionResponse?>>

    //Post Registration
    @POST(Endpoints.API_POST_REGISTRATION)
    fun submitRegistration(@Body request: RegistrationData): Call<GenericDataResponse<RegistrationResponse?>>

    //Put OTP
    @PUT(Endpoints.API_POST_REGISTRATION_OTP)
    fun submitRegistrationOtp(@Path("id") id: Int, @Body request: OtpData): Call<GenericDataResponse<OtpResponse?>>

    //Post Login
    @POST(Endpoints.API_POST_LOGIN)
    fun submitLogin(@Body request: Login): Call<GenericDataResponse<LoginResponse?>>

    //Post Login
    @POST(Endpoints.API_POST_FORGET)
    fun submitForgetPassword(@Body request: ForgotPassword): Call<GenericDataResponse<ForgetPasswordResponse?>>

    //POST Forget OTP
    @POST(Endpoints.API_POST_FORGET_OTP)
    fun submitForgetOtp(@Path("id") id: String, @Body request: OtpData): Call<GenericDataResponse<Any>>

    //POST Delete Account
    @POST(Endpoints.API_POST_DELETE_ACCOUNT)
    fun deleteAccount(): Call<GenericDataResponse<Any>>

    //POST Resend OTP
    @GET(Endpoints.API_GET_RESEND_OTP)
    fun submitResendOtp(@Path("email") email: String): Call<GenericDataResponse<Any>>

    //POST New Password
    @POST(Endpoints.API_POST_NEW_PASSWORD)
    fun submitNewPassword(@Path("id") id: String, @Path("code") code: String, @Body request: NewPassword): Call<GenericDataResponse<NewPasswordResponse>>

    //Get Tracking History
    @GET(Endpoints.API_GET_TRACKING_HISTORY)
    fun getTrackingHistory(): Call<GenericListDataResponse<TrackingSessionItem>>

    //Get Driver Tracking History
    @GET(Endpoints.API_GET_SESSION_HISTORY)
    fun getSessionHistory(@Path("id") id: Int): Call<GenericListDataResponse<TrackingSessionItem>>

    //Get Tracking item details
    @GET(Endpoints.API_GET_TRACKING_DETAILS)
    fun getTrackingItem(@Path("id") id: Int): Call<GenericDataResponse<TrackingSessionDetails>>

    //Post Add driver with track id
    @POST(Endpoints.API_POST_ADD_DRIVER)
    fun addDriver(@Body request: AddDriver): Call<GenericDataResponse<NewPasswordResponse>>

    //Post Check payment status
    @POST(Endpoints.API_POST_PAYMENT_STATUS_CHECK)
    fun checkPaymentStatus(@Body request: ValidatePaymentRequest): Call<GenericDataResponse<Any>>

    //Post Activate Subscription
    @POST(Endpoints.API_POST_ACTIVATE_SUBSCRIPTION)
    fun activateSubscription(@Body request: CreateSubscription): Call<GenericDataResponse<SubscribeResponse>>

    //Active Session
    @GET(Endpoints.API_GET_ACTIVE_SESSION)
    fun activeSession(): Call<GenericDataResponse<TrackingStatus>>

    //Start tracker
    @POST(Endpoints.API_POST_START_TRACKING)
    fun startTracking(@Body request: TrackingStart): Call<GenericDataResponse<TrackResponse>>

    //Stop tracker
    @POST(Endpoints.API_POST_STOP_TRACKING)
    fun stopTracking(@Body request: TrackingStop): Call<GenericDataResponse<Any>>

    //Send SOS
    @POST(Endpoints.API_POST_SOS)
    fun sendSos(): Call<GenericDataResponse<NewPasswordResponse>>

    //Get Share Info
    @GET(Endpoints.API_GET_SHARE_INFO)
    fun getShareInfo(): Call<GenericDataResponse<ShareInfoResponse>>

    //Get Subscription data
    @GET(Endpoints.API_GET_SUBSCRIPTION_INFO)
    fun getSubscriptionInfo(): Call<GenericDataResponse<SubscriptionData>>

    //Get Cost per month data
    @GET(Endpoints.API_GET_COST_PER_MONTH)
    fun getCostInfo(): Call<GenericDataResponse<CostPerMonthData>>

    //Get Coupon data
    @POST(Endpoints.API_GET_COUPON_DETAILS)
    fun getCouponDetails(@Body data: SubmitCoupon): Call<GenericDataResponse<CouponDetails>>

    //Get Vehicle List
    @GET(Endpoints.API_GET_VEHICLE_LIST)
    fun getMyVehicles(): Call<GenericListDataResponse<VehicleItem>>

    //Get Vehicle Type
    @GET(Endpoints.API_GET_VEHICLE_TYPE)
    fun getVehicleType(): Call<GenericListDataResponse<VehicleType>>

    //Post Vehicle Item
    @POST(Endpoints.API_POST_NEW_VEHICLE)
    fun addNewVehicle(@Body request: AddVehicle): Call<GenericDataResponse<VehicleResponse>>

    //Delete Vehicle Item
    @DELETE(Endpoints.API_EDIT_DELETE_VEHICLE)
    fun deleteVehicle(@Path("id") id: Int): Call<GenericDataResponse<Any>>

    //Edit Vehicle Item
    @PUT(Endpoints.API_EDIT_DELETE_VEHICLE)
    fun updateVehicle(@Path("id") id: Int, @Body request: AddVehicle): Call<GenericDataResponse<VehicleResponse>>

    //Get Driver List
    @GET(Endpoints.API_GET_DRIVER_LIST)
    fun getDriverList(): Call<GenericListDataResponse<DriverListResponse>>

    //Get Alert Data
    @GET(Endpoints.API_GET_MY_ALERT)
    fun getMyAlert(@Path("id") driverId: Int): Call<GenericDataResponse<AlertResponse>>

    //Post Alerts
    @POST(Endpoints.API_POST_ALERT)
    fun toggleAlert(@Body data: ToggleAlert, @Path("id") driverId: Int): Call<GenericDataResponse<Any>>

    //Post SOS
    @POST(Endpoints.API_POST_SPEED_LIMIT)
    fun changeSpeedAlert(@Body data: SpeedLimitRequest, @Path("id") driverId: Int): Call<GenericDataResponse<SpeedLimitResponse>>

    //Post SOS
    @POST(Endpoints.API_POST_BATTERY_LIMIT)
    fun changeBatteryAlert(@Body data: BatteryLimitRequest, @Path("id") driverId: Int): Call<GenericDataResponse<BatteryLimitResponse>>

    //Get Payment History List
    @GET(Endpoints.API_GET_PAYMENT_HISTORY_LIST)
    fun getPaymentHistoryList(): Call<GenericListDataResponse<PaymentHistoryItem>>

    //Post Edit Profile
    @PUT(Endpoints.API_PUT_EDIT_PROFILE)
    fun updateProfile(@Body data: UpdateProfileRequest): Call<GenericDataResponse<Profile>>

    //Post Profile picture
    @Multipart
    @POST(Endpoints.API_POST_PROFILE_PIC)
    fun updateProfilePicture(@Part file: MultipartBody.Part): Call<GenericDataResponse<LoginResponse>>

    //Post Update Password
    @PUT(Endpoints.API_POST_UPDATE_PASSWORD)
    fun updatePassword(@Body data: UpdatePassword): Call<GenericDataResponse<NewPasswordResponse>>

    //Get Issue list
    @GET(Endpoints.API_GET_ISSUE_LIST)
    fun getIssueList(): Call<GenericListDataResponse<IssueItem>>

    //Post Report
    @POST(Endpoints.API_POST_REPORT)
    fun createReport(@Body data: ReportRequest): Call<GenericDataResponse<ReportResponse>>

    //Get Report list
    @GET(Endpoints.API_GET_REPORT_LIST)
    fun getReportList(): Call<GenericListDataResponse<ReportHistoryItem>>

    //Post FCM Token
    @POST(Endpoints.API_POST_FCM)
    fun submitFcmToken(@Body request: FcmSubmission): Call<GenericDataResponse<Any>>

    //Get Notification list
    @GET(Endpoints.API_GET_NOTIFICATION_LIST)
    fun getNotificationList(): Call<GenericListDataResponse<NotificationItem>>

    //Put Notification read
    @PUT(Endpoints.API_GET_NOTIFICATION_LIST)
    fun readNotifications(@Body data: ReadAllRequest): Call<GenericDataResponse<Any>>*/
}