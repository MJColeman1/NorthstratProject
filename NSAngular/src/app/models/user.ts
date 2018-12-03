export class User {
  id: number;
  username: string;
  password: string;
  admin: boolean;
  firstName: string;
  lastName: string;
  email: string;
  title: string;


constructor(id?: number, username?: string, password?: string, admin?: boolean, firstName?: string,
  lastName?: string, email?: string, title?: string) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.admin = admin;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.title = title;
}
}
