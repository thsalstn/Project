$(document).ready(function(){
	//header
	
	
	$('.h_record').click(function(){
		location.href = "./Record.do";
	});
	
	$('.h_logo').click(function(){
		location.href = './Main.do';
	});
	
	
	
	$('.h_login').click(function(){
		location.href = './loginForm.do';
	});
	
	$('.h_join').click(function(){
		location.href = './memberform.do';
	});
	
	$('.h_logout').click(function(){
		location.href = './logOut.do';
	});
	
	$('.h_cjoin').click(function(){
		location.href = './counselorform.do';
	});
	
	$('.h_amend').click(function(){
		location.href = './member_info_update_form.do';
	});
	
	$('.h_camend').click(function(){
		location.href = './counselor_info_update_form.do';
	});
	//header
	
	//psychological
	$('.p_m_button').click(function(){
		location.href = './MBTI.do';
	});
	
	$('.p_s_button').click(function(){
		location.href = './Stress.do';
	});
	
	$('.p_d_button').click(function(){
		location.href = './Depression.do';
	});
	
	$('.p_a_button').click(function(){
		location.href = './Alcohol.do';
	});
	
	$('.p_g_button').click(function(){
		location.href = './Game.do';
	});
	//psychological
});