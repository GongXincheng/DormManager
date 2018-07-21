//显示Model提示框
function showMyModal(title,message){
	$("#modal_title").text(title);
	$("#modal_message").text(message);
	$("#myModal").modal('show');
}

//判断字符串是否为空
function isStrNull(str){
	if(str==null || str.length==0){
		return true;
	}
	return false;
}