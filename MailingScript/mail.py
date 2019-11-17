import smtplib
from smtplib import SMTPAuthenticationError, SMTPSenderRefused

from string import Template

from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText

MY_ADDRESS = input("Enter your Email ID: ")
PASSWORD = input("Enter your password: ")

def get_contacts(filename):
    """
    Return two lists names, emails containing names and email addresses
    read from a file specified by filename.
    """

    Roll_No = []
    emails = []
    subjects=[]
    with open(filename, mode='r', encoding='utf-8') as contacts_file:
        for a_contact in contacts_file:
            Roll_No.append(a_contact.split()[0])
            emails.append(a_contact.split()[1])
            subjects.append(" ".join(a_contact.split()[2:]))
    return Roll_No, emails, subjects

def read_template(filename):
    """
    Returns a Template object comprising the contents of the
    file specified by filename.
    """

    with open(filename, 'r', encoding='utf-8') as template_file:
        template_file_content = template_file.read()
    return Template(template_file_content)

def main():
    Roll_No, emails, subjects= get_contacts('mycontacts.txt') # read contacts
    message_template = read_template('message.txt')

    # set up the SMTP server
    s = smtplib.SMTP('smtp.gmail.com', 587)
    s.starttls()
    try:
        s.login(MY_ADDRESS, PASSWORD)
    except SMTPAuthenticationError:
        print("Login failed")
        return
    # For each contact, send the email:
    for rollno, email, subject in zip(Roll_No, emails, subjects):
        msg = MIMEMultipart()       # create a message

        # add in the actual person name to the message template
        message = message_template.substitute(ROLL_NO=rollno,SUB_NAME=subject)

        # Prints out the message body for our sake
        print(message)

        # setup the parameters of the message
        msg['From']=MY_ADDRESS
        msg['To']=email
        msg['Subject']="Attendance Default"

        # add in the message body
        msg.attach(MIMEText(message, 'plain'))

        # send the message via the server set up earlier.
        try:
            s.send_message(msg)
        except SMTPSenderRefused:
            print("You need to enable less secure apps")

        del msg

    # Terminate the SMTP session and close the connection
    s.quit()

if __name__ == '__main__':
    main()
