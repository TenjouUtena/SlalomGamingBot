#!/usr/bin/python
import discord
import asyncio

client = discord.Client()

@client.event
async def on_ready():
    print('Logged in as')
    print(client.user.name)
    print(client.user.id)
    print('------')


def findrole(targetrole):
    roleid = None
    for role in message.server.roles:
        if targetrole == role.name:
            roleid = role
    return roleid


async def addrole(message, targetrole):
    roleid = findrole(targetrole)
	if roleid == None:
		await client.send_message(message.channel, "I can't find that role")
	else:
	    await client.add_roles(message.author, roleid)
	    await client.send_message(message.channel, "Added!")
	



@client.event
async def on_message(message):
    tokens = message.content.split(" ")
    command = tokens[0]
    if message.channel.name == "botspam":
		if command.lower == "!iam":
		  await addrole(message, tokens[1])
	##print("CHANNEL: {}  MESSAGE: {}".format(message.channel, message.content))


## Keep the Token in a seperate file for sekrits
f = open('token','r')
client.run(f.read())

