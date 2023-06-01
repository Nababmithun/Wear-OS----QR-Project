package com.ewnbd.lifvesafer.network

object Endpoints {
    const val API_GET_SUBSCRIPTION = "/api/app-texts/TRIAL_DAY_HOME_MESSAGE/"

    const val API_POST_REGISTRATION = "/api/register/"
    const val API_POST_REGISTRATION_OTP = "/api/verify_number/{id}/"
    const val API_POST_LOGIN = "/api/login/"
    const val API_POST_FORGET = "/api/reset-password-generate-code/"
    const val API_POST_FORGET_OTP = "/api/reset-password-match-code/{id}/"
    const val API_GET_RESEND_OTP = "/api/resend-otp/{email}/"
    const val API_POST_NEW_PASSWORD = "/api/reset-password-set/{id}/{code}/"
    const val API_POST_DELETE_ACCOUNT = "/api/delete-account/"

    const val API_GET_TRACKING_HISTORY = "/api/tracking-history-user/"
    const val API_GET_SESSION_HISTORY = "/api/tracking-history/{id}/"
    const val API_GET_TRACKING_DETAILS = "/api/tacking-session-details/{id}/"
    const val API_POST_ADD_DRIVER = "/api/add-trackID-to-mylist/"

    const val API_POST_PAYMENT_STATUS_CHECK = "/api/payment-ref-info/"

    const val API_GET_ACTIVE_SESSION = "/api/active-tracking-session/"

    const val API_POST_START_TRACKING = "/api/start-tracking-session/"
    const val API_POST_STOP_TRACKING = "/api/stop-tracking-session/"

    const val API_POST_SOS = "/api/send-sos/"

    const val API_GET_SHARE_INFO = "/api/share-my-trackID/"
    const val API_GET_SUBSCRIPTION_INFO = "/api/current-subscription/"
    const val API_GET_COST_PER_MONTH = "/api/cost-per-month/"
    const val API_GET_COUPON_DETAILS = "/api/coupon-code-details/"

    const val API_POST_ACTIVATE_SUBSCRIPTION = "/api/subscribe/"

    const val API_GET_VEHICLE_LIST = "/api/my-vehicles/"
    const val API_GET_VEHICLE_TYPE = "/api/vehivle-type-list/"
    const val API_POST_NEW_VEHICLE = "/api/add-my-vehicle/"
    const val API_EDIT_DELETE_VEHICLE = "/api/manage-my-vehicle/{id}/"

    const val API_GET_DRIVER_LIST = "/api/my-driver-list/"

    const val API_GET_MY_ALERT = "/api/my-alerts/{id}/"
    const val API_POST_ALERT = "/api/turn-on-off-alert/{id}/"
    const val API_POST_SPEED_LIMIT = "/api/update-my-speed-limit/{id}/"
    const val API_POST_BATTERY_LIMIT = "/api/update-my-battery-limit/{id}/"

    const val API_GET_PAYMENT_HISTORY_LIST = "/api/user-payment-history/"

    const val API_PUT_EDIT_PROFILE = "/api/update-profile/"
    const val API_POST_PROFILE_PIC = "/api/update-profile-pic/"

    const val API_POST_UPDATE_PASSWORD = "/api/change-password/"

    const val API_GET_ISSUE_LIST = "/api/issue-category-list/"
    const val API_POST_REPORT = "/api/create_issue/"
    const val API_GET_REPORT_LIST = "/api/issue_list/"

    const val API_GET_NOTIFICATION_LIST = "/api/user-notification/"
    const val API_POST_FCM = "/api/add_device/"
}