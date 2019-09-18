import urllib.request
import json


class Floor:

    def create(self, file):
        self.__create_header(file)
        self.__create_content(file)
        self.__create_footer(file)

    def __create_header(self, file):
        file.write('package com.sdk.java.dmm.enums;\n')
        file.write('\n')
        file.write('import com.fasterxml.jackson.annotation.JsonCreator;\n')
        file.write('import lombok.AllArgsConstructor;\n')
        file.write('import lombok.Getter;\n')
        file.write('\n')
        file.write('/**\n')
        file.write(' * フロアID指定時に使用する列挙型\n')
        file.write(' */\n')
        file.write('@AllArgsConstructor\n')
        file.write('@Getter\n')
        file.write('public enum Floor implements CodeEnum<String> {\n')
        file.write('\n')

    def __create_footer(self, file):
        file.write('\n')
        file.write('  /** 値 */\n')
        file.write('  private String value;\n')
        file.write('  /** ラベル */\n')
        file.write('  private String label;\n')
        file.write('\n')
        file.write('  /**\n')
        file.write('   * 指定された値を持つ列挙型を返却します。\n')
        file.write('   *\n')
        file.write('   * @param value 列挙型の値\n')
        file.write('   * @return 指定された値を持つ列挙型\n')
        file.write('   */\n')
        file.write('  @JsonCreator\n')
        file.write('  public static Floor of(String value) {\n')
        file.write('    return CodeEnum.of(Floor.class, value);\n')
        file.write('  }\n')
        file.write('\n')
        file.write('}\n')

    def __create_content(self, file):
        url = 'https://api.dmm.com/affiliate/v3/FloorList'
        params = {
            'api_id': '',
            'affiliate_id': '',
            'output': 'json'
        }
        request = urllib.request.Request('{}?{}'.format(
            url, urllib.parse.urlencode(params)))

        with urllib.request.urlopen(request) as response:
            body = json.load(response)
            body['result']['site']
            for site in body['result']['site']:
                for service in site['service']:
                    for floor in service['floor']:
                        if site['code'] == body['result']['site'][-1]['code'] \
                                and service['code'] == site['service'][-1]['code'] \
                                and floor['id'] == service['floor'][-1]['id']:
                            self.__createField(
                                file, site, service, floor, True)
                            return
                        self.__createField(file, site, service, floor, False)

    def __createField(self, file, site, service, floor, is_last_field):
        if site['code'] == 'DMM.com':
            site_name = 'DMM'
        elif site['code'] == 'FANZA':
            site_name = 'FANZA'
        else:
            print('想定されていないサイトコードがAPIより返却されています。')
            exit(1)

        file.write('  /** ' + site_name + ' ' +
                   service['name'] + ' ' + floor['name'] + ' */\n')
        if is_last_field:
            file.write('  ' + site_name + '_' + service['code'].upper() + '_' + floor['code'].upper(
            ) + '("' + floor['id'] + '", "'
                + site_name + ',' + service['name'] + ',' + floor['name'] + '");\n')
        else:
            file.write('  ' + site_name + '_' + service['code'].upper() + '_' + floor['code'].upper(
            ) + '("' + floor['id'] + '", "'
                + site_name + ',' + service['name'] + ',' + floor['name'] + '"),\n')
