email_list = ['wendy.fleming@test.com',
							'stacy.smith@test.com',
							'harold.miller@example.com',
							'wendy.smith@test.com',
							'stacy.moorehall@test.com',
							'harold.meadows@test.com',
            ]


def print_names(name_list):
	"""prints names in list, one line for each name"""
	
	for name in name_list:
		print(name)


def convert_email_to_name (email_list):

	
	#split first and last name for capitalization
	first_name = []
	last_name = []
	
	#truncate everything after @
	email_list_trunc = []
	symbol ='@'
	for i,x in enumerate(email_list):
		#split first and last name for reordering
		name = x.split(symbol, 1)[0].split('.')
		first_name.append(name[0].capitalize())
		last_name.append(name[1].capitalize())
		
		
		email_list_trunc.append(first_name[i]+" "+last_name[i])
	
	#sorting by last name
	name_list = sorted(email_list_trunc, key=lambda x:x.split(" ")[-1])
	
	return name_list


if __name__ == "__main__":
  names = convert_email_to_name(email_list)
  print_names(names)
