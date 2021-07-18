package it.farmabyte.app.services;

public interface ISecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}