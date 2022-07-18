package ca.sheridancollege.antonye.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.antonye.model.Club;

@Repository
public class ClubDatabaseAccess {

	

	
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public long addClubMember(Club club) {
	MapSqlParameterSource namedParameters = new MapSqlParameterSource() ;
	String insert="INSERT INTO club (memberName, memberEmail, memberPhoneNumber)"
	            +"VALUES (:memberName, :memberEmail,:memberPhoneNumber);";
	namedParameters.addValue("memberName",club.getMemberName()) ;
	namedParameters.addValue("memberEmail",club.getMemberEmail());
	namedParameters.addValue("memberPhoneNumber",club.getMemberPhoneNumber());
	long rowsAffected = jdbc.update(insert, namedParameters);
	return rowsAffected;
	}
	
	public List<Club> selectClubMember(){
	MapSqlParameterSource namedParameters = new MapSqlParameterSource();
	String query="SELECT * FROM club";
	List<Club> club = jdbc.query (query, namedParameters,
	       new BeanPropertyRowMapper<Club> (Club.class)) ;
	return club;
	}

	public List<Club> selectmemberByPhoneNumber(String memberPhoneNumber) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
			String query="SELECT * FROM club where memberPhoneNumber = :memberPhoneNumber";
			namedParameters.addValue("memberPhoneNumber", memberPhoneNumber) ;
			List<Club> club = jdbc.query (query, namedParameters,
			               new BeanPropertyRowMapper<Club>(Club.class));
			return club;
			

	}
}
