def getPassword(name, website, secret, month, year):
	password = ""
	# name
	names = name.split()
	first = names[0].lower()
	surname = names[1].lower()
	password += surname[len(surname)-2:] + first[len(first)-2:] # last 2 of last, last 2 of first
	password = password[:1].upper() + password[1:] # capitalize the first

	# website
	website = website[1:2] + website[0:1]
	website = website[:1].upper() + website[1:].lower() # capitalize the first
	password += website

	# secret / special code
	password += secret

	# month
	vowels = "aeiouyAEIOUY"
	for ch in list(month):
		if ch in vowels:
			password += ch.lower()

	# year
	password += year[0:1]
	if int(year) > 2000:
		return password + year[len(year) - 1:]
	return password + year[2:3]
	# first and last if after 2000. first and third if before 2000

if __name__ == "__main__":
	name = input("First and Last Name: ")
	website = input("Website: ")
	secret = input("Special Code: ")
	month = input("Birth Month: ")
	year = input("Birth Year: ")
	print("\nPassword: " + getPassword(name, website, secret, month, year))
