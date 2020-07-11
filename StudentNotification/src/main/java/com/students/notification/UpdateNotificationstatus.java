package com.students.notification;

@Controller
public class UpdateNotificationstatus{
	@ResponseBody
	@RequestMapping("/changestatus")
	public void UpdateStatus(@RequestParam("username")String username,HttpSession session) throws ClassNotFoundException, SQLException {
		NotifyCourses notify=new NotifyCourses();
        JSONObject item=new JSONObject();
        item=notify.Updatestatus(username);
		session.setAttribute("notifications",item);
	}
}