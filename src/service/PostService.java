package service;

import dao.PostDao;
import domain.Post;


public class PostService {
	private PostDao postDao = new PostDao();
	
	public String getAllPosts(){
		return postDao.getAllPosts();
		
	}
	
	public void addPost(Post post) throws PostException{
		
		postDao.add(post);
		
	}
	
	public String FindPostByUsername(String username){
		return postDao.findPostByUsername(username);
	}

	
}
