import java.util.*;
class FriendNode {
    int friendId;
    FriendNode next;

    public FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}
class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friendList;
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendList = null;
        this.next = null;
    }

    public void addFriend(int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = friendList;
        friendList = newFriend;
    }

    public void removeFriend(int friendId) {
        FriendNode temp = friendList, prev = null;
        while (temp != null && temp.friendId != friendId) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) return;
        if (prev == null) friendList = temp.next;
        else prev.next = temp.next;
    }

    public boolean hasFriend(int friendId) {
        FriendNode temp = friendList;
        while (temp != null) {
            if (temp.friendId == friendId) return true;
            temp = temp.next;
        }
        return false;
    }

    public void displayFriends() {
        FriendNode temp = friendList;
        System.out.print("Friends of " + name + ": ");
        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int countFriends() {
        int count = 0;
        FriendNode temp = friendList;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

class SocialMedia {
    UserNode head;

    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        newUser.next = head;
        head = newUser;
    }

    public UserNode findUser(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    public UserNode findUserByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriendship(int userId1, int userId2) {
        UserNode user1 = findUser(userId1);
        UserNode user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            user1.addFriend(userId2);
            user2.addFriend(userId1);
        }
    }

    public void removeFriendship(int userId1, int userId2) {
        UserNode user1 = findUser(userId1);
        UserNode user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            user1.removeFriend(userId2);
            user2.removeFriend(userId1);
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUser(userId1);
        UserNode user2 = findUser(userId2);
        if (user1 == null || user2 == null) return;
        System.out.print("Mutual friends: ");
        FriendNode temp = user1.friendList;
        while (temp != null) {
            if (user2.hasFriend(temp.friendId)) System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void displayUserFriends(int userId) {
        UserNode user = findUser(userId);
        if (user != null) user.displayFriends();
    }

    public void countUserFriends(int userId) {
        UserNode user = findUser(userId);
        if (user != null) System.out.println(user.name + " has " + user.countFriends() + " friends.");
    }
}

public class Social {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMedia sm = new SocialMedia();
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 24);
        sm.addUser(3, "Charlie", 26);
        sm.addFriendship(1, 2);
        sm.addFriendship(1, 3);
        sm.displayUserFriends(1);
        sm.countUserFriends(1);
        sm.findMutualFriends(1, 2);
        sm.removeFriendship(1, 2);
        sm.displayUserFriends(1);
        sc.close();
    }
}