package fastcampas.aop.part2.aop_part3_chapter01

enum class NotificationType(val title: String, val id: Int) {
    NORMAL("일반 알림",0),
    EXPANDABLE("확장형 알림",1),
    CUSTOM("커스텀 알림",2)
}