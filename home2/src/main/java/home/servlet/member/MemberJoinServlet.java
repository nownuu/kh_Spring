package home.servlet.member;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import home.beans.MemberDao;
import home.beans.MemberDto;
import home.beans.MemberProfileDao;
import home.beans.MemberProfileDto;

@WebServlet(urlPatterns = "/member/join.kh")
public class MemberJoinServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String savePath = "D:/upload/member";
			int maxSize = 10*1024*1024;
			String encoding ="UTF-8";
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			MultipartRequest mRequest =
					new MultipartRequest(req, savePath, maxSize, encoding, policy);
			
			req.setCharacterEncoding("UTF-8");
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId(mRequest.getParameter("memberId"));
			memberDto.setMemberPw(mRequest.getParameter("memberPw"));
			memberDto.setMemberNick(mRequest.getParameter("memberNick"));
			memberDto.setMemberBirth(mRequest.getParameter("memberBirth"));
			memberDto.setMemberPhone(mRequest.getParameter("memberPhone"));
			memberDto.setMemberEmail(mRequest.getParameter("memberEmail"));
			
			MemberDao memberDao = new MemberDao();
			memberDao.join(memberDto);
			
			if(mRequest.getFile("attach") != null) {
				MemberProfileDto memberProfileDto = new MemberProfileDto();
				memberProfileDto.setMemberId(memberDto.getMemberId());
				memberProfileDto.setMemberFileSavename(mRequest.getFilesystemName("attach"));
				memberProfileDto.setMemberFileUploadname(mRequest.getOriginalFileName("attach"));
				memberProfileDto.setMemberFileType(mRequest.getContentType("attach"));
				File target = mRequest.getFile("attach");
				memberProfileDto.setMemberFileSize(target == null ? 0L : target.length());
				
				MemberProfileDao memberProfileDao = new MemberProfileDao();
				memberProfileDao.insert(memberProfileDto);
				
			}
			resp.sendRedirect("join_success.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500); //Internal server error
		}
	}
}