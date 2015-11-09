require 'net/http'

namespace :ping do
  desc "Ping our heroku dyno every 10, 60 or 3600 min"
  task :start do
    puts "Making the attempt to ping the dyno"

    if ENV['PING_URL']
      puts "Sending ping"

      uri = URI(ENV['PING_URL'])
      Net::HTTP.get_response(uri)

      puts "success..."
    end
  end
end